package software.daveturner.cuvbpoc.entity;



import java.io.Serializable;
import java.util.Objects;

public class CustId implements Serializable {

    protected String custIdentType;

    protected String custIdentId;

    public CustId(String custIdentType, String custId) {
        this.custIdentId = custId;
        this.custIdentType = custIdentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustId custId1 = (CustId) o;
        return Objects.equals(custIdentType, custId1.custIdentType) && Objects.equals(custIdentId, custId1.custIdentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custIdentType, custIdentId);
    }
}
