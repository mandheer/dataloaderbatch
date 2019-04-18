package in.pabreja.exercise.industrybuying.dataloaderbatch.validation;

import in.pabreja.exercise.industrybuying.dataloaderbatch.model.InputFormatData;
import in.pabreja.exercise.industrybuying.dataloaderbatch.stereotype.IndustryBuyingService;
import in.pabreja.exercise.industrybuying.dataloaderbatch.util.CommonUtil;

@IndustryBuyingService
public class InputDataValidatorImpl implements DataValidator<InputFormatData> {
    @Override
    public boolean isValid(InputFormatData item) {
        return checkDataType(item);
    }

    private boolean checkDataType(final InputFormatData item){
        if(item == null) return false;

        //trim the String data
        //This cleans the data :: commented because we don't need clean data for now.
        //

        /*item.setMsgId(CommonUtil.trim(item.getMsgId()));
        item.setMsgTxt(CommonUtil.trim(item.getMsgTxt()));

        if(CommonUtil.checkTruthVal(item.getIbTruthVal()))
            item.setIbTruthVal(CommonUtil.trim(item.getIbTruthVal()));

        if(CommonUtil.checkTruthVal(item.getCubeTruthVal()))
            item.setCubeTruthVal(CommonUtil.trim(item.getCubeTruthVal()));

        if(CommonUtil.checkTruthVal(item.getgTruthVal()))
                item.setgTruthVal(CommonUtil.trim(item.getgTruthVal()));
        if(CommonUtil.checkProbability(item.getgSpamProbVal(),item.getgNotSpamProbVal())) {
            item.setgSpamProbVal(CommonUtil.trim(item.getgSpamProbVal()));
            item.setgNotSpamProbVal(CommonUtil.trim(item.getgNotSpamProbVal()));
        }

        if(CommonUtil.checkTruthVal(item.getIbmTruthVal()))
            item.setIbmTruthVal(CommonUtil.trim(item.getIbmTruthVal()));
        if(CommonUtil.checkProbability(item.getIbmSpamProbVal(),item.getIbmNotSpamProbVal())) {
            item.setIbmSpamProbVal(CommonUtil.trim(item.getIbmSpamProbVal()));
            item.setIbmNotSpamProbVal(CommonUtil.trim(item.getIbmNotSpamProbVal()));
        }

        if(CommonUtil.isPhone(item.getPhone())){
            item.setPhone(CommonUtil.trim(item.getPhone()));
        }
        return true;*/
        return CommonUtil.checkTruthVal(item.getIbTruthVal()) &&
                CommonUtil.checkTruthVal(item.getCubeTruthVal()) &&
                CommonUtil.checkTruthVal(item.getgTruthVal()) && CommonUtil.checkProbability(item.getgSpamProbVal(),item.getgNotSpamProbVal()) &&
                CommonUtil.checkTruthVal(item.getIbmTruthVal()) && CommonUtil.checkProbability(item.getIbmSpamProbVal(),item.getIbmNotSpamProbVal()) &&
                CommonUtil.isPhone(item.getPhone());
    }
}
