package za.co.recruitment.dao;

import za.co.recruitment.model.Application;
import java.util.List;

public interface ApplicationDAO {

    Application saveApplication(Application application);

    List<Application> getAllApplications();

    Application getApplicationById(Long applicationId);

    void deleteApplication(Long applicationId);

}
