package za.co.recruitment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.recruitment.constant.RecruitmentConstant;
import za.co.recruitment.inbound.OfferInboundPayload;
import za.co.recruitment.outbound.OfferOutboundPayload;
import za.co.recruitment.processor.OfferProcessor;
import za.co.recruitment.service.OfferService;
import za.co.recruitment.validator.OfferValidator;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    OfferProcessor offerProcessor;

    @Autowired
    OfferValidator offerValidator;

    @Override
    public ResponseEntity<OfferOutboundPayload> saveOffer(OfferInboundPayload offerInboundPayload) {
        try {
            if (offerValidator.isValidJobTitle(offerInboundPayload.getJobTitle())) {
                return new ResponseEntity<>(offerProcessor.processOffer(offerInboundPayload), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(OfferOutboundPayload.builder().responseMessage(RecruitmentConstant.JOB_TITLE_EXISTS).build(), HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(OfferOutboundPayload.builder().responseMessage(e.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<OfferOutboundPayload>> getOffers() {
        try {
            return new ResponseEntity<>(offerProcessor.getOffers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<OfferOutboundPayload> getOfferById(Long offerId) {
        try {
            return new ResponseEntity<>(offerProcessor.getOfferById(offerId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(OfferOutboundPayload.builder().responseMessage(e.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
