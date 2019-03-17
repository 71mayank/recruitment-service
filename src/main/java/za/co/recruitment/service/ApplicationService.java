package za.co.recruitment.service;

import za.co.recruitment.model.Application;
import java.util.List;

public interface ApplicationService {

    Application saveApplication(Application application);

    List<Application> getAllApplications();

    Application getApplicationById(Long applicationId);

    void deleteApplication(Long applicationId);
}
