package in.pabreja.exercise.industrybuying.dataloaderbatch.exception;

public class IndustryBuyingBusinessException extends Exception {

    public IndustryBuyingBusinessException(){
        super();
    }

    public IndustryBuyingBusinessException(String message){
        super(message);
    }

    public IndustryBuyingBusinessException(String message, Throwable cause){
        super(message,cause);
    }

    public IndustryBuyingBusinessException(Throwable cause){
        super(cause);
    }


}
