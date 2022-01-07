package software.daveturner.cuvbpoc.repo;

import org.springframework.data.repository.CrudRepository;
import software.daveturner.cuvbpoc.entity.Cust;
import software.daveturner.cuvbpoc.entity.CustPk;

public interface CustRepo extends CrudRepository<Cust, CustPk> {
}
