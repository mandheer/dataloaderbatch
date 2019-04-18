package in.pabreja.exercise.industrybuying.dataloaderbatch.model;

/**
 * All the members are String to do manual validation on the input data
 *
 * Some times batch fails while data is coming null. So this is more secured and fail-safe way.
 *
 */
public class InputFormatData {
    private String msgId;
    private String msgTxt;
    private String phone;
    private String ibTruthVal;
    private String cubeTruthVal;
    private String gTruthVal;
    private String gSpamProbVal;
    private String gNotSpamProbVal;
    private String ibmTruthVal;
    private String ibmSpamProbVal;
    private String ibmNotSpamProbVal;

    public String getMsgId() {
        return msgId;
    }

    public String getMsgTxt() {
        return msgTxt;
    }

    public String getPhone() {
        return phone;
    }

    public String getIbTruthVal() {
        return ibTruthVal;
    }

    public String getCubeTruthVal() {
        return cubeTruthVal;
    }

    public String getgTruthVal() {
        return gTruthVal;
    }

    public String getgSpamProbVal() {
        return gSpamProbVal;
    }

    public String getgNotSpamProbVal() {
        return gNotSpamProbVal;
    }

    public String getIbmTruthVal() {
        return ibmTruthVal;
    }

    public String getIbmSpamProbVal() {
        return ibmSpamProbVal;
    }

    public String getIbmNotSpamProbVal() {
        return ibmNotSpamProbVal;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public void setMsgTxt(String msgTxt) {
        this.msgTxt = msgTxt;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIbTruthVal(String ibTruthVal) {
        this.ibTruthVal = ibTruthVal;
    }

    public void setCubeTruthVal(String cubeTruthVal) {
        this.cubeTruthVal = cubeTruthVal;
    }

    public void setgTruthVal(String gTruthVal) {
        this.gTruthVal = gTruthVal;
    }

    public void setgSpamProbVal(String gSpamProbVal) {
        this.gSpamProbVal = gSpamProbVal;
    }

    public void setgNotSpamProbVal(String gNotSpamProbVal) {
        this.gNotSpamProbVal = gNotSpamProbVal;
    }

    public void setIbmTruthVal(String ibmTruthVal) {
        this.ibmTruthVal = ibmTruthVal;
    }

    public void setIbmSpamProbVal(String ibmSpamProbVal) {
        this.ibmSpamProbVal = ibmSpamProbVal;
    }

    public void setIbmNotSpamProbVal(String ibmNotSpamProbVal) {
        this.ibmNotSpamProbVal = ibmNotSpamProbVal;
    }
}
