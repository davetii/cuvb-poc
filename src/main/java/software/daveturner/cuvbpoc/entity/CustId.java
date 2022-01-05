package software.daveturner.cuvbpoc.entity;


import javax.persistence.Column;
import java.io.Serializable;

public class CustId implements Serializable {

    private String custIdentType;
    private String custId;

    public CustId(String custIdentType, String custId) {
        this.custId = custId;
        this.custIdentType = custIdentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustId custId1 = (CustId) o;

        if (custIdentType != null ? !custIdentType.equals(custId1.custIdentType) : custId1.custIdentType != null)
            return false;
        return custId != null ? custId.equals(custId1.custId) : custId1.custId == null;
    }

    @Override
    public int hashCode() {
        int result = custIdentType != null ? custIdentType.hashCode() : 0;
        result = 31 * result + (custId != null ? custId.hashCode() : 0);
        return result;
    }
}
