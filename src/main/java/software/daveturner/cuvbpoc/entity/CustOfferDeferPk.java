package software.daveturner.cuvbpoc.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class CustOfferDeferPk extends CustPk implements Serializable {

    @Column(name = "OFFER_DT", nullable=false)
    protected LocalDate offerDate;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="custIdentType", referencedColumnName = "CUST_IDENT_TYPE"),
            @JoinColumn(name="custIdentId", referencedColumnName = "CUST_IDENT_ID")
    })
    private Cust cust;

    public CustOfferDeferPk(String custIdentType, String custIdentId, LocalDate offerDate) {
        super(custIdentType, custIdentId);
        this.offerDate = offerDate;
    }

    public CustOfferDeferPk() { }

    public LocalDate getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(LocalDate offerDate) {
        this.offerDate = offerDate;
    }

    public Cust getCust() {
        return cust;
    }

    public void setCust(Cust cust) {
        this.cust = cust;
    }
}
