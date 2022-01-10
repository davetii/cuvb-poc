package software.daveturner.cuvbpoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.daveturner.cuvbpoc.entity.Cust;
import software.daveturner.cuvbpoc.entity.CustOfferDefer;
import software.daveturner.cuvbpoc.entity.CustOfferDeferPk;
import software.daveturner.cuvbpoc.entity.CustPk;
import software.daveturner.cuvbpoc.model.Customer;
import software.daveturner.cuvbpoc.model.Offer;
import software.daveturner.cuvbpoc.model.OfferResponse;
import software.daveturner.cuvbpoc.repo.CustOfferDeferRepo;
import software.daveturner.cuvbpoc.repo.CustRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    CustRepo custRepo;
    @Autowired
    CustOfferDeferRepo custOfferDeferRepo;

    @Override
    public Optional<Customer> getCustomer(String custType, String custId) {
        Optional<Cust> cust = custRepo.findById(new CustPk(custType, custId));
        if(cust.isPresent()) {
            Customer customer = new Customer();
            customer.setCustId(custId);
            customer.setCustType(custType);
            customer.setDecision(cust.get().getDecisionStatusCode());
            customer.setDecisionTimestamp(cust.get().getDecisionStatusTimeStamp());
            customer.setDeclineReason(cust.get().getDeclineReasonCode());
            return Optional.of(customer);
        }
        return Optional.empty();
    }

    @Override
    public void save(Offer offer) {

        CustPk custPk = new CustPk();
        custPk.setCustIdentType(offer.getCustIdentType());
        custPk.setCustIdentId(offer.getCustIdentId());
        Cust cust = new Cust();
        cust.setCustPk(custPk);
        cust.setDecisionStatusCode(offer.getDecision());
        cust.setDecisionStatusTimeStamp(LocalDateTime.now());

        if(offer.getDecision().equals(OfferResponse.DECLINE.toString())) {
            cust.setDeclineReasonCode(offer.getReason());
        }

        if(OfferResponse.isValidResponse(offer.getDecision())) {
            custRepo.save(cust);

            if(offer.getDecision().equals(OfferResponse.DEFER.toString()) && offer.getReason() != null) {
                System.out.println("is null");
                CustOfferDeferPk deferPk = new CustOfferDeferPk();
                deferPk.setCust(cust);
                deferPk.setOfferDate(LocalDate.now());

                CustOfferDefer defer = new CustOfferDefer();
                defer.setCustOfferDeferPk(deferPk);
                defer.setDecisionDeferReasonCode(offer.getReason());

                custOfferDeferRepo.save(defer);
            } else {
                System.out.println("he was null");
            }
        }
    }
}
