package za.co.recruitment.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.recruitment.dao.impl.ApplicationDAOImpl;
import za.co.recruitment.model.Application;
import za.co.recruitment.service.ApplicationService;
import java.util.List;

@Service
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationDAOImpl applicationDAOImpl;


    @Override
    public Application saveApplication(Application application) {
        return applicationDAOImpl.saveApplication(application);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationDAOImpl.getAllApplications();
    }

    @Override
    public Application getApplicationById(Long applicationId) {
        return applicationDAOImpl.getApplicationById(applicationId);
    }

    @Override
    public void deleteApplication(Long applicationId) {
        applicationDAOImpl.deleteApplication(applicationId);
    }
}
