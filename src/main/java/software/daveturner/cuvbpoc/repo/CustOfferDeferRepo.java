package software.daveturner.cuvbpoc.repo;

import org.springframework.data.repository.CrudRepository;
import software.daveturner.cuvbpoc.entity.CustIdDate;
import software.daveturner.cuvbpoc.entity.CustOfferDefer;

public interface CustOfferDeferRepo extends CrudRepository<CustOfferDefer, CustIdDate> {

}
