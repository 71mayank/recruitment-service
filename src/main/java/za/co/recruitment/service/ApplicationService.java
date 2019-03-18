package za.co.recruitment.service;

import org.springframework.http.ResponseEntity;
import za.co.recruitment.inbound.ApplicationInboundPayload;
import za.co.recruitment.outbound.ApplicationOutboundPayload;
import java.util.List;

public interface ApplicationService {

    ResponseEntity<ApplicationOutboundPayload> applyForAnOffer(ApplicationInboundPayload applicationInboundPayload);

    ResponseEntity<List<ApplicationOutboundPayload>> getAllApplications();

    ResponseEntity<ApplicationOutboundPayload> getApplicationByIdPerOffer(Long applicationId,Long offerId);

    ResponseEntity<List<ApplicationOutboundPayload>> getApplicationsByOfferId(Long offerId);

    ResponseEntity<ApplicationOutboundPayload> updateApplicationStatus(String newApplicationStatus ,Long applicationId);

}
