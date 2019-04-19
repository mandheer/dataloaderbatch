package in.pabreja.exercise.industrybuying.dataloaderbatch.configuration;

import in.pabreja.exercise.industrybuying.dataloaderbatch.listener.IbMessageListener;
import in.pabreja.exercise.industrybuying.dataloaderbatch.model.InputFormatData;
import in.pabreja.exercise.industrybuying.dataloaderbatch.model.OutputFormatData;
import in.pabreja.exercise.industrybuying.dataloaderbatch.processor.MessageProcessor;
import in.pabreja.exercise.industrybuying.dataloaderbatch.stereotype.IndustryBuyingConfiguration;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.sql.SQLException;

@IndustryBuyingConfiguration
@EnableBatchProcessing
public class IbMessageConfigurer {

    @Value("${input.sourceFile}")
    private Resource inputResource;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    /**
     * configured reader here which has support for multiple file formats as defined by spring batch
     *
     * Flatfile reader is used for all types of files, only need to change is delimiter
     * @return the FlatFileItemReader Instance
     */
    @Bean
    public FlatFileItemReader<InputFormatData> reader(){
        return new FlatFileItemReaderBuilder<InputFormatData>()
                .name("ibMessageItemReader")
                .resource(inputResource)
                .linesToSkip(1)
                .encoding("UTF-8")
                .strict(false)
                .delimited()
                .delimiter(",")
                .names(new String[]{"msgId","msgTxt", "phone", "ibTruthVal", "cubeTruthVal",
                        "gTruthVal","gSpamProbVal", "gNotSpamProbVal",
                        "ibmTruthVal","ibmSpamProbVal", "ibmNotSpamProbVal"
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<InputFormatData>(){
                    {
                        setTargetType(InputFormatData.class);
                    }
                })
                .build();
    }

    @Bean
    public MessageProcessor processor() {
        return new MessageProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<OutputFormatData> writer(@Qualifier("oracleDs") DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<OutputFormatData>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO messagedata (" +
                        "m_id, message_str, m_phone, m_t_val, m_cube_val," +
                        " m_g_val, m_g_sprob, m_g_nsprob," +
                        " m_ibm_val, m_ibm_sprob, m_ibm_nsprob" +
                        ") VALUES (" +
                        ":msgId, :msgTxt, :phone, :ibTruthVal, :cubeTruthVal," +
                        " :gTruthVal, :gSpamProbVal, :gNotSpamProbVal," +
                        " :ibmTruthVal, :ibmSpamProbVal, :ibmNotSpamProbVal" +
                        ")")
                .dataSource(dataSource)
                .build();
    }
    // end::readerwriterprocessor[]

    @Bean
    public Job importUserJob(IbMessageListener ibMessageListener, Step step1){
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(ibMessageListener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<OutputFormatData> writer) {
        return stepBuilderFactory.get("step1")
                .<InputFormatData, OutputFormatData> chunk(100)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }


    @Bean("oracleDs")
    @ConfigurationProperties(prefix="oracle.datasource")
    public DataSource dataSource() throws SQLException {
        return DataSourceBuilder.create().build();
    }

}
