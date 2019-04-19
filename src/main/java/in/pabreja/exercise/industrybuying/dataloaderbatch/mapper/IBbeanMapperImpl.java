package in.pabreja.exercise.industrybuying.dataloaderbatch.mapper;

import in.pabreja.exercise.industrybuying.dataloaderbatch.model.InputFormatData;
import in.pabreja.exercise.industrybuying.dataloaderbatch.model.OutputFormatData;
import in.pabreja.exercise.industrybuying.dataloaderbatch.util.CommonUtil;
import org.springframework.stereotype.Service;

@Service
public class IBbeanMapperImpl implements IndustryBuyingBeanMapper<InputFormatData, OutputFormatData> {
    @Override
    public OutputFormatData map(final InputFormatData ip) {
        OutputFormatData od = new OutputFormatData();

        od.setMsgId(ip.getMsgId());
        od.setMsgTxt(ip.getMsgTxt());
//        if(CommonUtil.isPhone(ip.getPhone())) -- NOT REQUIRED AS IT IS STRING NOW IN DB
            od.setPhone(ip.getPhone());
        // unable to insert null values in phone

        od.setIbTruthVal(ip.getIbTruthVal());

        od.setCubeTruthVal(ip.getCubeTruthVal());

        od.setgTruthVal(ip.getgTruthVal());
        od.setgSpamProbVal(ip.getgSpamProbVal());
        od.setgNotSpamProbVal(ip.getgNotSpamProbVal());

        od.setIbmTruthVal(ip.getIbmTruthVal());
        od.setIbmSpamProbVal(ip.getIbmSpamProbVal());
        od.setIbmNotSpamProbVal(ip.getIbmNotSpamProbVal());
        return od;
    }
}
