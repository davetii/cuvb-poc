package software.daveturner.cuvbpoc.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class CustIdDate extends CustId implements Serializable {

    protected LocalDate offerDate;

    public CustIdDate(String custIdentType, String custId, LocalDate offerDate) {
        super(custIdentType, custId);
        this.offerDate = offerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CustIdDate that = (CustIdDate) o;
        return Objects.equals(offerDate, that.offerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), offerDate);
    }
}
