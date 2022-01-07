package software.daveturner.cuvbpoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.daveturner.cuvbpoc.entity.Cust;
import software.daveturner.cuvbpoc.entity.CustOfferDefer;
import software.daveturner.cuvbpoc.entity.CustOfferDeferPk;
import software.daveturner.cuvbpoc.entity.CustPk;
import software.daveturner.cuvbpoc.model.Offer;
import software.daveturner.cuvbpoc.model.OfferResponse;
import software.daveturner.cuvbpoc.repo.CustOfferDeferRepo;
import software.daveturner.cuvbpoc.repo.CustRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    CustRepo custRepo;
    @Autowired
    CustOfferDeferRepo custOfferDeferRepo;

    @Override
    public void save(Offer offer) {

        CustPk custPk = new CustPk();
        custPk.setCustIdentType(offer.getCustIdentType());
        custPk.setCustIdentId(offer.getCustIdentId());
        Cust cust = new Cust();
        cust.setCustPk(custPk);
        cust.setDecisionStatusCode(offer.getDecision());
        cust.setDecisionStatusTimeStamp(LocalDateTime.now());

        if(OfferResponse.isValidResponse(offer.getDecision())) {
            custRepo.save(cust);

            if(offer.getDecision().equals(OfferResponse.DEFER) && offer.getReason() != null) {
                CustOfferDeferPk deferPk = new CustOfferDeferPk();
                deferPk.setCust(cust);
                deferPk.setOfferDate(LocalDate.now());

                CustOfferDefer defer = new CustOfferDefer();
                defer.setCustOfferDeferPk(deferPk);
                defer.setDecisionDeferReasonCode(offer.getReason());

                custOfferDeferRepo.save(defer);
            }
        }
    }
}
