package za.co.recruitment.service;


import za.co.recruitment.model.Offer;

import java.util.List;

public interface OfferService {

    Offer saveOffer(Offer offer);

    List<Offer> getOffers();

    Offer getOfferById(Long offerId);

    void deleteOffer(Long offerId);
}
