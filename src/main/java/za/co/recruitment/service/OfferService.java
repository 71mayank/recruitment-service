package za.co.recruitment.service;

import za.co.recruitment.inbound.OfferInboundPayload;
import za.co.recruitment.outbound.OfferOutboundPayload;

import java.util.List;

public interface OfferService {

    OfferOutboundPayload saveOffer(OfferInboundPayload offerInboundPayload);

    List<OfferOutboundPayload> getOffers();

    OfferOutboundPayload getOfferById(Long offerId);

}
