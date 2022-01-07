package software.daveturner.cuvbpoc.repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import software.daveturner.cuvbpoc.BaseVBOfferTest;
import software.daveturner.cuvbpoc.entity.Cust;
import software.daveturner.cuvbpoc.entity.CustOfferDefer;
import software.daveturner.cuvbpoc.entity.CustOfferDeferPk;
import software.daveturner.cuvbpoc.entity.CustPk;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustOfferDeferRepoTest extends BaseVBOfferTest {

    @Test
    public void ensureCustConstraintViolationThrowsError() {
        Assertions.assertThrows(DataIntegrityViolationException.class, ()-> {
                    CustOfferDefer offerDefer  = newCustOfferDefer(DEFAULT_DEFER_ID, "Random reason");
                    offerRepo.save(offerDefer);
        }, "DataIntegrityViolationException thrown");
    }

    @Test
    public void ensureAddOfferReturnsExpected() {
        CustPk custPk = newCustPK("TEST_TYPE", "2");
        Cust cust = newCust(custPk,"TEST_DECISION" );
        custRepo.save(cust);
        assertEquals(0, offerRepo.count());
        CustOfferDeferPk offerPk = new CustOfferDeferPk(custPk.getCustIdentType(), custPk.getCustIdentType(), LocalDate.now());
        offerPk.setCust(cust);
        CustOfferDefer offerDefer  = newCustOfferDefer(offerPk, "SOMEREASON");
        offerRepo.save(offerDefer);
        assertEquals(1, offerRepo.count());
        CustOfferDefer fetchedOfferDefer = offerRepo.findAll().iterator().next();
        CustPk fetchedCustomerPk = fetchedOfferDefer.getCustOfferDeferPk().getCust().getCustPk();
        assertEquals("2", fetchedCustomerPk.getCustIdentId());
        assertEquals("TEST_TYPE", fetchedCustomerPk.getCustIdentType());
        assertEquals("SOMEREASON", fetchedOfferDefer.getDecisionDeferReasonCode());
        assertNotNull(fetchedOfferDefer.getCustOfferDeferPk().getOfferDate());
    }

    private CustOfferDefer newCustOfferDefer(CustOfferDeferPk offerPk, String reason) {
        CustOfferDefer offerDefer  = new CustOfferDefer();
        offerDefer.setCustOfferDeferPk(offerPk);
        offerDefer.setDecisionDeferReasonCode(reason);
        return offerDefer;
    }

}
