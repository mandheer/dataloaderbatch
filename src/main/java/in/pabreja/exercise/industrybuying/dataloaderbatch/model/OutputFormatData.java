package in.pabreja.exercise.industrybuying.dataloaderbatch.model;

/**
 * All the members are String to do manual validation on the input data
 *
 * Some times batch fails while data is coming null. So this is more secured and fail-safe way.
 *
 */
public class OutputFormatData {
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

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgTxt() {
        return msgTxt;
    }

    public void setMsgTxt(String msgTxt) {
        this.msgTxt = msgTxt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIbTruthVal() {
        return ibTruthVal;
    }

    public void setIbTruthVal(String ibTruthVal) {
        this.ibTruthVal = ibTruthVal;
    }

    public String getCubeTruthVal() {
        return cubeTruthVal;
    }

    public void setCubeTruthVal(String cubeTruthVal) {
        this.cubeTruthVal = cubeTruthVal;
    }

    public String getgTruthVal() {
        return gTruthVal;
    }

    public void setgTruthVal(String gTruthVal) {
        this.gTruthVal = gTruthVal;
    }

    public String getgSpamProbVal() {
        return gSpamProbVal;
    }

    public void setgSpamProbVal(String gSpamProbVal) {
        this.gSpamProbVal = gSpamProbVal;
    }

    public String getgNotSpamProbVal() {
        return gNotSpamProbVal;
    }

    public void setgNotSpamProbVal(String gNotSpamProbVal) {
        this.gNotSpamProbVal = gNotSpamProbVal;
    }

    public String getIbmTruthVal() {
        return ibmTruthVal;
    }

    public void setIbmTruthVal(String ibmTruthVal) {
        this.ibmTruthVal = ibmTruthVal;
    }

    public String getIbmSpamProbVal() {
        return ibmSpamProbVal;
    }

    public void setIbmSpamProbVal(String ibmSpamProbVal) {
        this.ibmSpamProbVal = ibmSpamProbVal;
    }

    public String getIbmNotSpamProbVal() {
        return ibmNotSpamProbVal;
    }

    public void setIbmNotSpamProbVal(String ibmNotSpamProbVal) {
        this.ibmNotSpamProbVal = ibmNotSpamProbVal;
    }
}
