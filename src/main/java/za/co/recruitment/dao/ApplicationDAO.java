package za.co.recruitment.dao;

import za.co.recruitment.model.Application;
import java.util.List;

public interface ApplicationDAO {

    Application saveApplication(Application application);

    List<Application> getAllApplications();

    Application getApplicationByIdPerOffer(Long applicationId, Long offerId);

    List<Application> getApplicationsByOfferId(Long offerId);

    Application getApplicationByEmailPerOffer(String candidateEmail, Long offerId);

    Application updateApplicationStatus(String newApplicationStatus,Long applicationId);

    Application getApplicationById(Long applicationId);

}
