package za.co.recruitment.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import za.co.recruitment.dao.OfferDAO;
import za.co.recruitment.model.Offer;
import za.co.recruitment.repository.OfferRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class OfferDAOImpl implements OfferDAO {

    @Autowired
    private OfferRepository offerRepository;


    @Override
    public Offer saveOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public List<Offer> getOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Offer getOfferById(Long offerId) {
        return offerRepository.getOne(offerId);
    }

    @Override
    public void deleteOffer(Long offerId) {
        offerRepository.deleteById(offerId);
    }
}
