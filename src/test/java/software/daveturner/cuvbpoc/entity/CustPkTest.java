package software.daveturner.cuvbpoc.entity;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustPkTest {

    CustPk custPk;

    @BeforeEach
    public void setup() {
        custPk = new CustPk();
        custPk.setCustIdentType("TYPE1");
        custPk.setCustIdentId("ID1");
    }

    @Test
    public void ensureEqualsReturnsExpected() {
        CustPk custPk_type1 = new CustPk();
        custPk_type1.setCustIdentType("TYPE1");
        custPk_type1.setCustIdentId("ID1");

        CustPk custPk_type2 = new CustPk();
        custPk_type2.setCustIdentType("TYPE2");
        custPk_type2.setCustIdentId("ID2");

        assertTrue(custPk.equals(custPk_type1));
        assertTrue(custPk.hashCode() == custPk_type1.hashCode());
        assertFalse(custPk.equals(custPk_type2));
        assertFalse(custPk.hashCode() == custPk_type2.hashCode());




    }




}

