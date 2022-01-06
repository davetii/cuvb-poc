package software.daveturner.cuvbpoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "CUST_OFFER_DEFER")
@IdClass(CustIdDate.class)
public class CustOfferDefer {

    public CustOfferDefer() {}

    @JsonBackReference
    @ManyToOne
    @Id
    @JoinColumns( {
            @JoinColumn(name="custIdentType", referencedColumnName="CUST_IDENT_TYPE"),
            @JoinColumn(name="custIdentId", referencedColumnName="CUST_IDENT_ID")
    } )
    private Cust cust;

    @Id
    @Column(name = "OFFER_DT", nullable=false)
    private LocalDate offerDate;

    @Column(name = "DECISION_DEFER_REASON_CD", nullable=false)
    private String decisionDeferReasonCode;

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
