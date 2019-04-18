package in.pabreja.exercise.industrybuying.dataloaderbatch.validation;

import in.pabreja.exercise.industrybuying.dataloaderbatch.stereotype.IndustryBuyingService;
import in.pabreja.exercise.industrybuying.dataloaderbatch.model.OutputFormatData;

@IndustryBuyingService
public class OutputDataValidatorImpl implements DataValidator<OutputFormatData> {
    @Override
    public boolean isValid(OutputFormatData item) {
        return checkDataType(item);
    }

    private boolean checkDataType(final OutputFormatData item){
        if(item == null) return false;
        // TODO: add the output validation logic here if reqired
        else return true;
    }
}
