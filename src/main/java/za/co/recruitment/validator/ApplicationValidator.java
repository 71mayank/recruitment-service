package za.co.recruitment.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.recruitment.dao.impl.ApplicationDAOImpl;
import za.co.recruitment.dao.impl.OfferDAOImpl;
import za.co.recruitment.enumeration.ApplicationEnum;
import za.co.recruitment.inbound.ApplicationInboundPayload;
import za.co.recruitment.model.Application;
import java.util.Objects;

@Component
public class ApplicationValidator {

    @Autowired
    ApplicationDAOImpl applicationDAOImpl;

    @Autowired
    OfferDAOImpl offerDAOImpl;

    public boolean isValidCandidateEmailPerOffer(ApplicationInboundPayload applicationInboundPayload){
        return Objects.isNull(applicationDAOImpl.getApplicationByEmailPerOffer(applicationInboundPayload.getCandidateEmail(), applicationInboundPayload.getRelatedOffer()));
    }

    public boolean ifRelatedOfferDoesNotExist(Long offerId){
        return Objects.isNull(offerDAOImpl.getOfferById(offerId));
    }

    public boolean isApplicationExists(Long applicationId){
        Application applicationById = applicationDAOImpl.getApplicationById(applicationId);
        return Objects.nonNull(applicationById) && applicationById.getId().longValue()==applicationId.longValue();
    }

    public boolean newStatusExistsInAvailableStatuses(String newApplicationStatus) {
        for (ApplicationEnum applicationEnum : ApplicationEnum.values()) {
            if (applicationEnum.name().equals(newApplicationStatus)) {
                return true;
            }
        }
        return false;
    }

}
