package za.co.recruitment.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.recruitment.dao.impl.ApplicationDAOImpl;
import za.co.recruitment.enumeration.ApplicationEnum;
import za.co.recruitment.inbound.ApplicationInboundPayload;
import za.co.recruitment.model.Application;
import za.co.recruitment.outbound.ApplicationOutboundPayload;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApplicationProcessor {

    @Autowired
    private ApplicationDAOImpl applicationDAOImpl;


    public ApplicationOutboundPayload applyForAnOffer(ApplicationInboundPayload applicationInboundPayload) {
        applicationInboundPayload.setApplicationStatus(ApplicationEnum.APPLIED.name());
        return mapApplicationEntityToApplicationOutboundPayload(applicationDAOImpl.saveApplication(buildApplication(applicationInboundPayload)));
    }

    private ApplicationOutboundPayload mapApplicationEntityToApplicationOutboundPayload(Application application) {
        return   ApplicationOutboundPayload.builder()
                .applicationId(application.getId())
                .applicationStatus(application.getApplicationStatus())
                .candidateEmail(application.getCandidateEmail())
                .relatedOffer(application.getRelatedOffer())
                .resumeText(application.getResumeText())
                .build();
    }


    private Application buildApplication(ApplicationInboundPayload applicationInboundPayload){
        return   Application.builder()
                .applicationStatus(applicationInboundPayload.getApplicationStatus())
                .candidateEmail(applicationInboundPayload.getCandidateEmail())
                .relatedOffer(applicationInboundPayload.getRelatedOffer())
                .resumeText(applicationInboundPayload.getResumeText())
                .build();
    }

    public List<ApplicationOutboundPayload> getAllApplications() {
        return applicationDAOImpl.getAllApplications().stream().map(this::mapApplicationEntityToApplicationOutboundPayload).collect(Collectors.toList());
    }


    public List<ApplicationOutboundPayload> getApplicationsByOfferId(Long offerId) {
        return applicationDAOImpl.getApplicationsByOfferId(offerId).stream().map(this::mapApplicationEntityToApplicationOutboundPayload).collect(Collectors.toList());
    }

    public ApplicationOutboundPayload getApplicationByIdPerOffer(Long applicationId, Long offerId){
        return mapApplicationEntityToApplicationOutboundPayload(applicationDAOImpl.getApplicationByIdPerOffer(applicationId,offerId));
    }

}
