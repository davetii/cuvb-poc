package software.daveturner.cuvbpoc.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CUST")
@IdClass(CustId.class)
public class Cust  {

    public Cust() { }

    /*
    @Id
    @JoinColumns( {
            @JoinColumn(name="custIdentType", referencedColumnName="CUST_IDENT_TYPE"),
            @JoinColumn(name="custIdentId", referencedColumnName="CUST_IDENT_ID")
    } )
    private CustId custId;

     */

    @Id
    @Column(name = "CUST_IDENT_TYPE", nullable=false)
    private String custIdentType;

    @Id
    @Column(name = "CUST_IDENT_ID", nullable=false)
    private String custIdentId;

    @Column(name = "DECISION_STATUS_CD", nullable=false)
    private String decisionStatusCode;

    @Column(name = "DECISION_STATUS_TIMSTM", nullable=false)
    private LocalDateTime decisionStatusTimeStamp;

    @Column(name = "DECLINE_REASON_CD")
    private String declineReasonCode;

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
}

