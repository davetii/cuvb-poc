package software.daveturner.cuvbpoc.model;

public class Offer {

    private String custIdentType;
    private String custIdentId;
    private String decision;
    private String reason;

    public String getCustIdentType() {
        return custIdentType;
    }

    public void setCustIdentType(String custIdentType) {
        this.custIdentType = custIdentType;
    }

    public String getCustIdentId() {
        return custIdentId;
    }

    public void setCustIdentId(String custIdentId) {
        this.custIdentId = custIdentId;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
