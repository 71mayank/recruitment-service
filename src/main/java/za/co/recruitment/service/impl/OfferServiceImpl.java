package za.co.recruitment.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.recruitment.dao.impl.OfferDAOImpl;
import za.co.recruitment.model.Offer;
import za.co.recruitment.service.OfferService;
import java.util.List;

@Service
@Slf4j
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferDAOImpl offerDAOImpl;


    @Override
    public Offer saveOffer(Offer offer) {
        return offerDAOImpl.saveOffer(offer);
    }

    @Override
    public List<Offer> getOffers() {
        return offerDAOImpl.getOffers();
    }

    @Override
    public Offer getOfferById(Long offerId) {
        return offerDAOImpl.getOfferById(offerId);
    }

    @Override
    public void deleteOffer(Long offerId) {
        offerDAOImpl.deleteOffer(offerId);
    }
}
