package software.daveturner.cuvbpoc.repo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import software.daveturner.cuvbpoc.entity.Cust;
import software.daveturner.cuvbpoc.entity.CustOfferDeferPk;
import software.daveturner.cuvbpoc.entity.CustPk;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class BaseRepoTest {

    public final String DEFAULT_CUST_IDENT_ID = "ID1";
    public final String DEFAULT_CUST_IDENT_TYPE = "TYPE1";
    public final String DEFAULT_DECISION = "DECISION1";
    public CustPk DEFAULT_ID = new CustPk(DEFAULT_CUST_IDENT_TYPE, DEFAULT_CUST_IDENT_ID);
    public final CustOfferDeferPk DEFAULT_DEFER_ID = new CustOfferDeferPk(DEFAULT_CUST_IDENT_TYPE, DEFAULT_CUST_IDENT_ID, LocalDate.now());

    @Autowired
    protected CustRepo custRepo;

    @Autowired
    CustOfferDeferRepo offerRepo;

    protected Cust cust;

    LocalDateTime initTime = LocalDateTime.now();

    @BeforeEach
    public void setup() {
        Assertions.assertEquals(0, custRepo.count());
        cust = new Cust();
        cust.setCustPk(DEFAULT_ID);
        cust.setDecisionStatusCode(DEFAULT_DECISION);
        cust.setDecisionStatusTimeStamp(initTime);
        custRepo.save(cust);
        Assertions.assertEquals(1, custRepo.count());
    }

    @AfterEach()
    public void cleanup() {
        offerRepo.deleteAll();
        custRepo.deleteAll();
    }


}
