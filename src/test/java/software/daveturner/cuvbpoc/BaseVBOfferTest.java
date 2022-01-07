package software.daveturner.cuvbpoc;

import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import software.daveturner.cuvbpoc.entity.Cust;
import software.daveturner.cuvbpoc.entity.CustOfferDeferPk;
import software.daveturner.cuvbpoc.entity.CustPk;
import software.daveturner.cuvbpoc.repo.CustOfferDeferRepo;
import software.daveturner.cuvbpoc.repo.CustRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class BaseVBOfferTest {

    public final String DEFAULT_CUST_IDENT_ID = "ID1";
    public final String DEFAULT_CUST_IDENT_TYPE = "TYPE1";
    public final String DEFAULT_DECISION = "DECISION1";
    public CustPk DEFAULT_ID = new CustPk(DEFAULT_CUST_IDENT_TYPE, DEFAULT_CUST_IDENT_ID);
    public final CustOfferDeferPk DEFAULT_DEFER_ID = new CustOfferDeferPk(DEFAULT_CUST_IDENT_TYPE, DEFAULT_CUST_IDENT_ID, LocalDate.now());

    @Autowired
    protected CustRepo custRepo;

    @Autowired
    protected CustOfferDeferRepo offerRepo;

    protected Cust cust;

    @AfterEach()
    public void cleanup() {
        offerRepo.deleteAll();
        custRepo.deleteAll();
    }

    public Cust newCust(CustPk pk, String decision) {
        Cust cust = new Cust();
        cust.setCustPk(pk);
        cust.setDecisionStatusCode(decision);
        cust.setDecisionStatusTimeStamp(LocalDateTime.now());
        return cust;
    }

    public CustPk newCustPK(String type, String id) {
        CustPk custPk = new CustPk();
        custPk.setCustIdentId(id);
        custPk.setCustIdentType(type);
        return custPk;
    }


}
