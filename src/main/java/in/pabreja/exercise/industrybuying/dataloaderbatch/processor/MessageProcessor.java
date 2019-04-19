package in.pabreja.exercise.industrybuying.dataloaderbatch.processor;

import in.pabreja.exercise.industrybuying.dataloaderbatch.exception.IndustryBuyingBusinessException;
import in.pabreja.exercise.industrybuying.dataloaderbatch.mapper.IndustryBuyingBeanMapper;
import in.pabreja.exercise.industrybuying.dataloaderbatch.model.InputFormatData;
import in.pabreja.exercise.industrybuying.dataloaderbatch.model.OutputFormatData;
import in.pabreja.exercise.industrybuying.dataloaderbatch.validation.DataValidationFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The bean creation would be defined in IndustryBuyingMessageConfigurer
 */
public class MessageProcessor implements ItemProcessor<InputFormatData, OutputFormatData> {

    private static final Logger log = LoggerFactory.getLogger(MessageProcessor.class);

    @Autowired
    private DataValidationFactory validatonFactory;

    @Autowired
    private IndustryBuyingBeanMapper<InputFormatData,OutputFormatData> industryBuyingBeanMapper;

    @Override
    public OutputFormatData process(InputFormatData item) throws Exception {

        OutputFormatData odItem =null;
        //validation code here
        if(!validatonFactory.validate(item)){
            // here we can throw exception if we want to stop the job if the input has bad data
            log.error("Initial input data validation failed for data {}\n Exiting the batch",item);
            validatonFactory.validate(item);
            //throw new IndustryBuyingBusinessException("Bad input data");

            //if we want to skip the row which has bad data then
             return null;
        }
        // data mapping here
        odItem = industryBuyingBeanMapper.map(item);

        if(!validatonFactory.validate(odItem)){
            throw new IndustryBuyingBusinessException("Bad output data");
        }

        return odItem;
    }
}
