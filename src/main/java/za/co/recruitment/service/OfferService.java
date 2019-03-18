package za.co.recruitment.service;

import org.springframework.http.ResponseEntity;
import za.co.recruitment.inbound.OfferInboundPayload;
import za.co.recruitment.outbound.OfferOutboundPayload;
import java.util.List;

public interface OfferService {

    ResponseEntity<OfferOutboundPayload> saveOffer(OfferInboundPayload offerInboundPayload);

    ResponseEntity<List<OfferOutboundPayload>> getOffers();

    ResponseEntity<OfferOutboundPayload> getOfferById(Long offerId);

}
