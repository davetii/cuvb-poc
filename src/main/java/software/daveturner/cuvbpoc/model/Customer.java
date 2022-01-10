package software.daveturner.cuvbpoc.model;

import java.time.LocalDateTime;

public class Customer {

    private String custType;
    private String custId;
    private String decision;
    private LocalDateTime decisionTimestamp;
    private String declineReason;

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public LocalDateTime getDecisionTimestamp() {
        return decisionTimestamp;
    }

    public void setDecisionTimestamp(LocalDateTime decisionTimestamp) {
        this.decisionTimestamp = decisionTimestamp;
    }

    public String getDeclineReason() {
        return declineReason;
    }

    public void setDeclineReason(String declineReason) {
        this.declineReason = declineReason;
    }
}
