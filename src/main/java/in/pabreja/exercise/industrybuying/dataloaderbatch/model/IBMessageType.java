package in.pabreja.exercise.industrybuying.dataloaderbatch.model;

public enum IBMessageType {
    SPAM("spam"),
    NOT_SPAM("not-spam");

    private String type;

    IBMessageType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public static IBMessageType fromString(String type) {
        for (IBMessageType b : IBMessageType.values()) {
            if (b.type.equalsIgnoreCase(type)) {
                return b;
            }
        }
        return null;
    }

}
