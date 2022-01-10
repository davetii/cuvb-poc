package software.daveturner.cuvbpoc.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.daveturner.cuvbpoc.BaseVBOfferTest;
import software.daveturner.cuvbpoc.model.Customer;
import software.daveturner.cuvbpoc.model.Offer;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OfferServiceImplTest extends BaseVBOfferTest {

    @Autowired
    OfferServiceImpl offerService;

    @AfterEach()
    public void cleanup() {
        deferRepo.deleteAll();
        custRepo.deleteAll();
    }

    @Test
    public void ensureSaveAcceptReturnsExpected() {
        assertEquals(0, custRepo.count());
        offerService.save(newOffer("ACCEPT"));
        assertEquals(1, custRepo.count());
        assertEquals(0, deferRepo.count());
    }

    @Test
    public void ensureSaveDeclineReturnsExpected() {
        assertEquals(0, custRepo.count());
        offerService.save(newOffer("DECLINE", "SOMEREASON"));
        assertEquals(1, custRepo.count());
        assertEquals(0, deferRepo.count());
    }

    @Test
    public void ensureSaveDeferDecisionReturnsExpected() {
        Offer offer = newOffer("DEFER", "TOOBUSY");
        offerService.save(offer);
        assertEquals(1, custRepo.count());
        assertEquals(1, deferRepo.count());
    }

    @Test
    public void ensureAcceptedGetCustomerReturnsExpected() {
        offerService.save(newOffer("ACCEPT"));
        Optional<Customer> customer = offerService.getCustomer(DEFAULT_CUST_IDENT_TYPE, DEFAULT_CUST_IDENT_ID);
        assertEquals(DEFAULT_CUST_IDENT_ID, customer.get().getCustId());
        assertEquals(DEFAULT_CUST_IDENT_TYPE, customer.get().getCustType());
        assertEquals("ACCEPT", customer.get().getDecision());
        assertNotNull(customer.get().getDecisionTimestamp());
    }

    @Test
    public void ensureInAppropriateDeclineReasonReturnsExpected() {
        offerService.save(newOffer("ACCEPT", "NOTSAVED"));
        Optional<Customer> customer = offerService.getCustomer(DEFAULT_CUST_IDENT_TYPE, DEFAULT_CUST_IDENT_ID);
        assertEquals(DEFAULT_CUST_IDENT_ID, customer.get().getCustId());
        assertEquals(DEFAULT_CUST_IDENT_TYPE, customer.get().getCustType());
        assertEquals("ACCEPT", customer.get().getDecision());
        assertNotNull(customer.get().getDecisionTimestamp());
        assertNull(customer.get().getDeclineReason());
    }

    @Test
    public void ensureDeclineGetCustomerReturnsExpected() {
        offerService.save(newOffer("DECLINE", "NOTWANTED"));
        Optional<Customer> customer = offerService.getCustomer(DEFAULT_CUST_IDENT_TYPE, DEFAULT_CUST_IDENT_ID);
        assertEquals(DEFAULT_CUST_IDENT_ID, customer.get().getCustId());
        assertEquals(DEFAULT_CUST_IDENT_TYPE, customer.get().getCustType());
        assertEquals("DECLINE", customer.get().getDecision());
        assertNotNull(customer.get().getDecisionTimestamp());
        assertEquals("NOTWANTED", customer.get().getDeclineReason());
    }

    private Offer newOffer(String decision) {
        return newOffer(decision, null);
    }

    private Offer newOffer(String decision, String reason) {
        Offer offer  = new Offer();
        offer.setCustIdentId(DEFAULT_CUST_IDENT_ID);
        offer.setCustIdentType(DEFAULT_CUST_IDENT_TYPE);
        offer.setDecision(decision);
        if(reason != null) {
            offer.setReason(reason);
        }
        return offer;
    }







}
