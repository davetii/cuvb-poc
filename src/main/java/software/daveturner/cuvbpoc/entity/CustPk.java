package software.daveturner.cuvbpoc.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CustPk implements Serializable {

    @Column(name = "CUST_IDENT_TYPE", nullable=false)
    private String custIdentType;

    @Column(name = "CUST_IDENT_ID", nullable=false)
    private String custIdentId;

    public CustPk(String custIdentType, String custId) {
        this.custIdentId = custId;
        this.custIdentType = custIdentType;
    }

    public CustPk() { }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustPk custPk = (CustPk) o;
        return Objects.equals(custIdentType, custPk.custIdentType) && Objects.equals(custIdentId, custPk.custIdentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custIdentType, custIdentId);
    }
}
