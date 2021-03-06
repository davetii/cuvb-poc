package software.daveturner.cuvbpoc.repo;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import software.daveturner.cuvbpoc.BaseVBOfferTest;
import software.daveturner.cuvbpoc.entity.Cust;
import software.daveturner.cuvbpoc.entity.CustPk;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustRepoTest extends BaseVBOfferTest {

    @BeforeEach
    public void setup () {
        cust = new Cust();
        cust.setCustPk(DEFAULT_ID);
        cust.setDecisionStatusCode(DEFAULT_DECISION);
        cust.setDecisionStatusTimeStamp(LocalDateTime.now());
        custRepo.save(cust);
    }

    @Test
    public void ensureCustRepoAddReturnsExpected() {
        CustPk id = custRepo.findAll().iterator().next().getCustPk();
        assertEquals(DEFAULT_CUST_IDENT_ID, custRepo.findById(id).get().getCustPk().getCustIdentId());
        assertEquals(DEFAULT_CUST_IDENT_TYPE, custRepo.findById(id).get().getCustPk().getCustIdentType());
        assertEquals(DEFAULT_DECISION, custRepo.findById(id).get().getDecisionStatusCode());
    }

    @Test
    public void ensureCustRepoUpdateReturnsExpected() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Cust custToUpdate = custRepo.findById(DEFAULT_ID).get();
        custToUpdate.setDecisionStatusCode("changedstatuscode");
        LocalDateTime newTime = LocalDateTime.now();
        custToUpdate.setDecisionStatusTimeStamp(newTime);
        custToUpdate.setDeclineReasonCode("changedreason");
        assertEquals(DEFAULT_DECISION, custRepo.findById(DEFAULT_ID).get().getDecisionStatusCode());
        custRepo.save(custToUpdate);
        assertEquals("changedstatuscode", custRepo.findById(DEFAULT_ID).get().getDecisionStatusCode());
        assertEquals("changedreason", custRepo.findById(DEFAULT_ID).get().getDeclineReasonCode());
        assertEquals(newTime.format(dateFormat), custRepo.findById(DEFAULT_ID).get().getDecisionStatusTimeStamp().format(dateFormat));
    }

    @Test
    public void ensureUKReturnsExpected() {
        Cust cust2 = new Cust();
        cust2.setCustPk(DEFAULT_ID);
        cust2.setDecisionStatusCode("DECISION2");
        cust2.setDecisionStatusTimeStamp(LocalDateTime.now());
        custRepo.save(cust2);

        Cust cust3 = new Cust();
        cust3.setCustPk(DEFAULT_ID);
        cust3.setDecisionStatusCode("DECISION3");
        cust3.setDecisionStatusTimeStamp(LocalDateTime.now());
        custRepo.save(cust3);

        assertEquals(1, custRepo.count());
    }


}
