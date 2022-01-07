package software.daveturner.cuvbpoc.repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import software.daveturner.cuvbpoc.entity.Cust;
import software.daveturner.cuvbpoc.entity.CustOfferDefer;
import software.daveturner.cuvbpoc.entity.CustOfferDeferPk;
import software.daveturner.cuvbpoc.entity.CustPk;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustOfferDeferRepoTest extends BaseRepoTest {

    @Test
    public void ensureCustConstraintViolationThrowsError() {
        Assertions.assertThrows(DataIntegrityViolationException.class, ()-> {
                    CustOfferDefer offerDefer  = new CustOfferDefer();
                    offerDefer.setCustOfferDeferPk(DEFAULT_DEFER_ID);
                    offerDefer.setDecisionDeferReasonCode("Random reason");
                    offerRepo.save(offerDefer);
        }, "DataIntegrityViolationException should be thrown");
    }

    @Test
    public void ensureAddOfferReturnsExpected() {

        CustPk custPk = new CustPk();
        custPk.setCustIdentId("2");
        custPk.setCustIdentType("TEST_TYPE");
        Cust cust = new Cust();
        cust.setCustPk(custPk);
        cust.setDecisionStatusCode("TEST_DECISION");
        cust.setDecisionStatusTimeStamp(LocalDateTime.now());
        custRepo.save(cust);
        assertEquals(0, offerRepo.count());
        CustOfferDeferPk offerPk = new CustOfferDeferPk(custPk.getCustIdentType(), custPk.getCustIdentType(), LocalDate.now());
        offerPk.setCust(cust);
        CustOfferDefer offerDefer  = new CustOfferDefer();
        offerDefer.setCustOfferDeferPk(offerPk);
        offerDefer.setDecisionDeferReasonCode("SOMEREASON");
        offerRepo.save(offerDefer);
        assertEquals(1, offerRepo.count());
        CustOfferDefer fetchedOfferDefer = offerRepo.findAll().iterator().next();
        CustPk fetchedCustomerPk = fetchedOfferDefer.getCustOfferDeferPk().getCust().getCustPk();
        assertEquals("2", fetchedCustomerPk.getCustIdentId());
        assertEquals("TEST_TYPE", fetchedCustomerPk.getCustIdentType());
        assertEquals("SOMEREASON", fetchedOfferDefer.getDecisionDeferReasonCode());
        assertNotNull(fetchedOfferDefer.getCustOfferDeferPk().getOfferDate());
    }

}
