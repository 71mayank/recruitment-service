package za.co.recruitment.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.recruitment.constant.RecruitmentConstant;
import za.co.recruitment.dao.impl.OfferDAOImpl;
import za.co.recruitment.inbound.OfferInboundPayload;
import za.co.recruitment.model.Offer;
import za.co.recruitment.outbound.OfferOutboundPayload;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OfferProcessor {

    @Autowired
    private OfferDAOImpl offerDAOImpl;


    private Offer extractOfferDetailsAndBuildOffer(OfferInboundPayload offerInboundPayload) {
        return Offer.builder()
                .numberOfApplications(offerInboundPayload.getNumberOfApplications())
                .startDate(LocalDateTime.now())
                .jobTitle(offerInboundPayload.getJobTitle()).build();
        }


    public OfferOutboundPayload processOffer(OfferInboundPayload offerInboundPayload) {
        return mapOfferToOfferOutboundPayload(offerDAOImpl.saveOffer(extractOfferDetailsAndBuildOffer(offerInboundPayload)));
    }

    private OfferOutboundPayload mapOfferToOfferOutboundPayload(Offer offer) {
        return OfferOutboundPayload.builder()
                .offerId(offer.getId())
                .jobTitle(offer.getJobTitle())
                .numberOfApplications(offer.getNumberOfApplications())
                .startDate(offer.getStartDate())
                .responseMessage(RecruitmentConstant.JOB_OFFER_CREATED)
                .build();
    }

    public List<OfferOutboundPayload> getOffers() {
        return offerDAOImpl.getOffers().stream().map(this::mapOfferToOfferOutboundPayload).collect(Collectors.toList());
    }

    public OfferOutboundPayload getOfferById(Long offerId) {
        return mapOfferToOfferOutboundPayload(offerDAOImpl.getOfferById(offerId));
    }
}
