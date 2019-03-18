package za.co.recruitment.dao;

import za.co.recruitment.model.Offer;
import java.util.List;

public interface OfferDAO {

    Offer saveOffer(Offer offer);

    List<Offer> getOffers();

    Offer getOfferById(Long offerId);

    Offer getOfferByJobTitle(String  jobTitle);
}
