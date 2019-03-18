package za.co.recruitment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.recruitment.constant.RecruitmentConstant;
import za.co.recruitment.inbound.ApplicationInboundPayload;
import za.co.recruitment.outbound.ApplicationOutboundPayload;
import za.co.recruitment.processor.ApplicationProcessor;
import za.co.recruitment.service.ApplicationService;
import za.co.recruitment.validator.ApplicationValidator;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationProcessor applicationProcessor;

    @Autowired
    ApplicationValidator applicationValidator;

    @Override
    public ResponseEntity<ApplicationOutboundPayload> applyForAnOffer(ApplicationInboundPayload applicationInboundPayload) {
        try {
            if (applicationValidator.ifRelatedOfferDoesNotExist(applicationInboundPayload.getRelatedOffer())) {
                return new ResponseEntity<>(ApplicationOutboundPayload.builder().responseMessage(RecruitmentConstant.OFFER_DOES_NOT_EXIST).build(), HttpStatus.OK);
            }
            if (applicationValidator.isValidCandidateEmailPerOffer(applicationInboundPayload)) {
                return new ResponseEntity<>(applicationProcessor.applyForAnOffer(applicationInboundPayload), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(ApplicationOutboundPayload.builder().responseMessage(RecruitmentConstant.APPLICATION_EMAIL_EXISTS).build(), HttpStatus.CONFLICT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(ApplicationOutboundPayload.builder().responseMessage(e.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<ApplicationOutboundPayload>> getAllApplications() {
        try {
            return new ResponseEntity<>(applicationProcessor.getAllApplications(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ApplicationOutboundPayload> getApplicationByIdPerOffer(Long applicationId, Long offerId) {
        try {
            return new ResponseEntity<>(applicationProcessor.getApplicationByIdPerOffer(applicationId, offerId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(ApplicationOutboundPayload.builder().responseMessage(e.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<ApplicationOutboundPayload>> getApplicationsByOfferId(Long offerId) {
        try {
            return new ResponseEntity<>(applicationProcessor.getApplicationsByOfferId(offerId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<ApplicationOutboundPayload> updateApplicationStatus(String newApplicationStatus, Long applicationId) {
        try {
            if (applicationValidator.isApplicationExists(applicationId)) {
                if (applicationValidator.newStatusExistsInAvailableStatuses(newApplicationStatus.toUpperCase())) {
                    ApplicationOutboundPayload applicationOutboundPayload = applicationProcessor.updateApplicationStatus(newApplicationStatus.toUpperCase(), applicationId);
                    return new ResponseEntity<>(applicationOutboundPayload, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(ApplicationOutboundPayload.builder().responseMessage(RecruitmentConstant.VALID_APPLICATION_STATUS).build(), HttpStatus.BAD_REQUEST);
                }
            } else {
                return new ResponseEntity<>(ApplicationOutboundPayload.builder().responseMessage(RecruitmentConstant.APPLICATION_NOT_EXISTS).build(), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(ApplicationOutboundPayload.builder().responseMessage(e.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
