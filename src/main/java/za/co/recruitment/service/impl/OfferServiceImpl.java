package za.co.recruitment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.recruitment.inbound.OfferInboundPayload;
import za.co.recruitment.outbound.OfferOutboundPayload;
import za.co.recruitment.processor.OfferProcessor;
import za.co.recruitment.service.OfferService;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    OfferProcessor offerProcessor;

    @Override
    public OfferOutboundPayload saveOffer(OfferInboundPayload offerInboundPayload) {
        return offerProcessor.processOffer(offerInboundPayload);
    }

    @Override
    public List<OfferOutboundPayload> getOffers() {
        return offerProcessor.getOffers();
    }

    @Override
    public OfferOutboundPayload getOfferById(Long offerId) {
        return offerProcessor.getOfferById(offerId);
    }

}
