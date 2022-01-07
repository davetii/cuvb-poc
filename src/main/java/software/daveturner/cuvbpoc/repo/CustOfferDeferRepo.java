package software.daveturner.cuvbpoc.repo;

import org.springframework.data.repository.CrudRepository;
import software.daveturner.cuvbpoc.entity.CustOfferDeferPk;
import software.daveturner.cuvbpoc.entity.CustOfferDefer;

public interface CustOfferDeferRepo extends CrudRepository<CustOfferDefer, CustOfferDeferPk> {
}
