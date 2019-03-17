package za.co.recruitment.service;

import za.co.recruitment.inbound.ApplicationInboundPayload;
import za.co.recruitment.outbound.ApplicationOutboundPayload;
import java.util.List;

public interface ApplicationService {

    ApplicationOutboundPayload applyForAnOffer(ApplicationInboundPayload applicationInboundPayload);

    List<ApplicationOutboundPayload> getAllApplications();

    ApplicationOutboundPayload getApplicationByIdPerOffer(Long applicationId,Long offerId);

    List<ApplicationOutboundPayload> getApplicationsByOfferId(Long offerId);

}
