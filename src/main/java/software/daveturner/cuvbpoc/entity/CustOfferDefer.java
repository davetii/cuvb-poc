package software.daveturner.cuvbpoc.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CUST_OFFER_DEFER")
@IdClass(CustId.class)
public class CustOfferDefer {

    public CustOfferDefer() {}

    @Id
    @Column(name = "CUST_IDENT_TYPE", nullable=false)
    private String custIdentType;

    @Id
    @Column(name = "CUST_IDENT_ID", nullable=false)
    private String custId;

    @Column(name = "OFFER_DT", nullable=false)
    private LocalDate offerDate;

    @Column(name = "DECISION_DEFER_REASON_CD", nullable=false)
    private String decisionDeferReasonCode;

    public String getCustIdentType() {
        return custIdentType;
    }

    public void setCustIdentType(String custIdentType) {
        this.custIdentType = custIdentType;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public LocalDate getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(LocalDate offerDate) {
        this.offerDate = offerDate;
    }

    public String getDecisionDeferReasonCode() {
        return decisionDeferReasonCode;
    }

    public void setDecisionDeferReasonCode(String decisionDeferReasonCode) {
        this.decisionDeferReasonCode = decisionDeferReasonCode;
    }
}
