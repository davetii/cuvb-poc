package software.daveturner.cuvbpoc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "CUST")
public class Cust implements Serializable {

    @EmbeddedId
    private CustPk custPk;

    @Column(name = "DECISION_STATUS_CD", nullable=false)
    private String decisionStatusCode;

    @Column(name = "DECISION_STATUS_TIMSTM", nullable=false)
    private LocalDateTime decisionStatusTimeStamp;

    @Column(name = "DECLINE_REASON_CD")
    private String declineReasonCode;

    public CustPk getCustPk() {
        return custPk;
    }

    public void setCustPk(CustPk custPk) {
        this.custPk = custPk;
    }

    public String getDecisionStatusCode() {
        return decisionStatusCode;
    }

    public void setDecisionStatusCode(String decisionStatusCode) {
        this.decisionStatusCode = decisionStatusCode;
    }

    public LocalDateTime getDecisionStatusTimeStamp() {
        return decisionStatusTimeStamp;
    }

    public void setDecisionStatusTimeStamp(LocalDateTime decisionStatusTimeStamp) {
        this.decisionStatusTimeStamp = decisionStatusTimeStamp;
    }

    public String getDeclineReasonCode() {
        return declineReasonCode;
    }

    public void setDeclineReasonCode(String declineReasonCode) {
        this.declineReasonCode = declineReasonCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cust cust = (Cust) o;
        return Objects.equals(custPk, cust.custPk) && Objects.equals(decisionStatusCode, cust.decisionStatusCode) && Objects.equals(decisionStatusTimeStamp, cust.decisionStatusTimeStamp) && Objects.equals(declineReasonCode, cust.declineReasonCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custPk, decisionStatusCode, decisionStatusTimeStamp, declineReasonCode);
    }
}
