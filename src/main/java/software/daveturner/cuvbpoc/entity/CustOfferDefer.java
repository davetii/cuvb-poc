package software.daveturner.cuvbpoc.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CUST_OFFER_DEFER")
public class CustOfferDefer implements Serializable {

    @EmbeddedId
    private CustOfferDeferPk custOfferDeferPk;

    @Column(name = "DECISION_DEFER_REASON_CD", nullable=false)
    private String decisionDeferReasonCode;

    public CustOfferDeferPk getCustOfferDeferPk() {
        return custOfferDeferPk;
    }

    public void setCustOfferDeferPk(CustOfferDeferPk custOfferDeferPk) {
        this.custOfferDeferPk = custOfferDeferPk;
    }

    public String getDecisionDeferReasonCode() {
        return decisionDeferReasonCode;
    }

    public void setDecisionDeferReasonCode(String decisionDeferReasonCode) {
        this.decisionDeferReasonCode = decisionDeferReasonCode;
    }

}
