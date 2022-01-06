package software.daveturner.cuvbpoc.repo;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.daveturner.cuvbpoc.entity.Cust;
import software.daveturner.cuvbpoc.entity.CustId;

import java.time.LocalDateTime;

@SpringBootTest
public class CustRepoTest {

    @Autowired
    CustRepo repo;

    @AfterEach()
    public void cleanup() {
        repo.deleteAll();
    }

    @Test
    public void ensureCustRepoAddReturnsExpected() {
        CustId custId = new CustId("1", "randomtype");
        Cust cust = new Cust();
        cust.setCustIdentType("randomtype");
        cust.setCustIdentId("1");
        cust.setDecisionStatusCode("randomStatusCode");
        cust.setDecisionStatusTimeStamp(LocalDateTime.now());
        repo.save(cust);
        Assertions.assertEquals(1, repo.count());
    }
}
