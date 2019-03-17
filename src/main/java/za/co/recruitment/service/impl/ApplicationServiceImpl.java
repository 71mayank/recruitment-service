package za.co.recruitment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.recruitment.inbound.ApplicationInboundPayload;
import za.co.recruitment.outbound.ApplicationOutboundPayload;
import za.co.recruitment.processor.ApplicationProcessor;
import za.co.recruitment.service.ApplicationService;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationProcessor applicationProcessor;


    @Override
    public ApplicationOutboundPayload applyForAnOffer(ApplicationInboundPayload applicationInboundPayload) {
        return applicationProcessor.applyForAnOffer(applicationInboundPayload);
    }

    @Override
    public List<ApplicationOutboundPayload> getAllApplications() {
        return applicationProcessor.getAllApplications();
    }

    @Override
    public ApplicationOutboundPayload getApplicationByIdPerOffer(Long applicationId, Long offerId) {
        return applicationProcessor.getApplicationByIdPerOffer(applicationId, offerId);
    }

    @Override
    public List<ApplicationOutboundPayload> getApplicationsByOfferId(Long offerId) {
        return applicationProcessor.getApplicationsByOfferId(offerId);
    }


}
