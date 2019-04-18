package in.pabreja.exercise.industrybuying.dataloaderbatch.validation;

import in.pabreja.exercise.industrybuying.dataloaderbatch.model.InputFormatData;
import in.pabreja.exercise.industrybuying.dataloaderbatch.stereotype.IndustryBuyingFactory;
import in.pabreja.exercise.industrybuying.dataloaderbatch.exception.IndustryBuyingBusinessException;
import in.pabreja.exercise.industrybuying.dataloaderbatch.model.OutputFormatData;
import org.springframework.beans.factory.annotation.Autowired;

@IndustryBuyingFactory
public class DataValidationFactory {

    @Autowired
    private DataValidator<InputFormatData> inputFormatDataDataValidator;

    @Autowired
    private DataValidator<OutputFormatData> outputFormatDataDataValidator;

    public boolean validate(Object data) throws IndustryBuyingBusinessException{
        if(data == null){
            return false; // we can throw exception as well if we want.
        }
        if(data instanceof InputFormatData){
            return inputFormatDataDataValidator.isValid((InputFormatData)data);
        }
        if(data instanceof OutputFormatData){
            return outputFormatDataDataValidator.isValid((OutputFormatData) data);
        }
        throw new IndustryBuyingBusinessException("invalid data for validation");
    }
}
