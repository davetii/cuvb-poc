package software.daveturner.cuvbpoc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.daveturner.cuvbpoc.BaseVBOfferTest;
import software.daveturner.cuvbpoc.model.Offer;

@SpringBootTest
public class OfferServiceImplTest extends BaseVBOfferTest {

    @Autowired
    OfferServiceImpl offerService;

    @Test
    public void ensureServiceSaveReturnsExpected() {
        Assertions.assertEquals(0, custRepo.count());
        Offer offer = new Offer();
        offer.setCustIdentType("TYPE1");
        offer.setCustIdentId("ID1");
        offer.setDecision("ACCEPT");
        offerService.save(offer);
        Assertions.assertEquals(1, custRepo.count());
        Assertions.assertEquals(0, offerRepo.count());

    }





}
