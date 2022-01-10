package software.daveturner.cuvbpoc.service;

import software.daveturner.cuvbpoc.model.Customer;
import software.daveturner.cuvbpoc.model.Offer;

import java.util.Optional;

public interface OfferService {

    void save(Offer offer);
    Optional<Customer> getCustomer(String custType, String custId);

}
