package in.pabreja.exercise.industrybuying.dataloaderbatch.util;

import in.pabreja.exercise.industrybuying.dataloaderbatch.model.IBMessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public final class CommonUtil {

    private static final Logger log = LoggerFactory.getLogger(CommonUtil.class);

    public static boolean isPhone(String phone){
        if(Objects.isNull(phone)) return false;
        try{
            Integer.parseInt(phone);
            /*

            //implemented throws for no reason :: commented because throws is additional overhead for program flow

            if(phone.trim().length() != 10){
                throw new IndustryBuyingBusinessException("the phone number provided is not valid");
            }*/
        } catch(NumberFormatException nfe) {
            log.error("Unable to parse String {}, exception {}",phone,nfe);
            return false;
        } /*catch (IndustryBuyingBusinessException e) {
            log.error(e.getMessage());
            return false;
        }*/
        return phone.trim().length() == 10 ? true : false;
    }

    public static String trim(String str){
        if(str==null) return null;
        else return str.trim();
    }

    public static boolean checkTruthVal(String str){
        return IBMessageType.fromString(str) != null ? true : false;
    }

    public static boolean checkProbability(String sProb,String nsProb){
        try{
            return Double.parseDouble(sProb)+Double.parseDouble(nsProb) == 1 ? true : false;
        } catch (NumberFormatException nfe){
            log.error("Unable to parse String {} or {} with exception {}",sProb,nsProb,nfe);
            return false;
        }
    }


}
