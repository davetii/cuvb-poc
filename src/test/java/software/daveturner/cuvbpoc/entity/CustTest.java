package software.daveturner.cuvbpoc.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustTest {


    @Test
    public void ensureEqualsReturnsExpected() {
        LocalDateTime moment1 = LocalDateTime.now();
        CustPk custPk1 = new CustPk();
        custPk1.setCustIdentId("id1");
        custPk1.setCustIdentType("type1");

        Cust cust1 = new Cust();
        cust1.setCustPk(custPk1);
        cust1.setDeclineReasonCode("decline1");
        cust1.setDecisionStatusTimeStamp(moment1);
        cust1.setDecisionStatusCode("decision1");

        Cust cust2 = new Cust();
        cust2.setCustPk(custPk1);
        cust2.setDeclineReasonCode("decline1");
        cust2.setDecisionStatusTimeStamp(moment1);
        cust2.setDecisionStatusCode("decision1");

        assertTrue(cust1.equals(cust2));
        assertTrue(cust1.hashCode() == cust2.hashCode());
        cust2.setDecisionStatusCode("decision2");
        assertFalse(cust1.equals(cust2));
        assertFalse(cust1.hashCode() == cust2.hashCode());
        cust2.setDecisionStatusCode("decision1");
        assertTrue(cust1.equals(cust2));
        assertTrue(cust1.hashCode() == cust2.hashCode());
    }
}
