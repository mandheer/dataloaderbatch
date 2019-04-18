package in.pabreja.exercise.industrybuying.dataloaderbatch.configuration;

import in.pabreja.exercise.industrybuying.dataloaderbatch.model.InputFormatData;
import in.pabreja.exercise.industrybuying.dataloaderbatch.model.OutputFormatData;
import in.pabreja.exercise.industrybuying.dataloaderbatch.processor.MessageProcessor;
import in.pabreja.exercise.industrybuying.dataloaderbatch.stereotype.IndustryBuyingConfiguration;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@IndustryBuyingConfiguration
@EnableBatchProcessing
public class IbMessageConfigurer {

    @Value("${input.sourceFile}")
    private Resource inputResource;


    /**
     * configured reader here which has support for multiple file formats as defined by spring batch
     *
     * Flatfile reader is used for all types of files, only need to change is delimiter
     * @return the FlatFileItemReader Instance
     */
    @Bean
    public FlatFileItemReader<InputFormatData> reader(){
        return new FlatFileItemReaderBuilder<InputFormatData>()
                .name("")
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
    public JdbcBatchItemWriter<OutputFormatData> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<OutputFormatData>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO message (first_name, last_name) VALUES (:firstName, :lastName)")
                .dataSource(dataSource)
                .build();
    }
    // end::readerwriterprocessor[]

    /*@Bean
    public Job importUserJob(FeeCalcStatusListener feeCalcStatusListener, Step step1){
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(feeCalcStatusListener)
                .flow(step1)
                .end()
                .build();
    }*/



}
