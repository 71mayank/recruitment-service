package za.co.recruitment.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import za.co.recruitment.dao.ApplicationDAO;
import za.co.recruitment.model.Application;
import za.co.recruitment.repository.ApplicationRepository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ApplicationDAOImpl implements ApplicationDAO {

    @Autowired
    private ApplicationRepository applicationRepository;


    @Override
    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Application getApplicationByIdPerOffer(Long applicationId, Long offerId) {
        return applicationRepository.getApplicationByIdPerOffer(applicationId,offerId);
    }

    @Override
    public List<Application> getApplicationsByOfferId(Long offerId) {
        return applicationRepository.getApplicationsByOfferId(offerId);
    }

    @Override
    public Application getApplicationByEmailPerOffer(String candidateEmail,Long offerId) {
        return applicationRepository.getApplicationByEmailPerOffer(candidateEmail,offerId);
    }

    @Override
    public Application updateApplicationStatus(String newApplicationStatus, Long applicationId) {
        Application application = applicationRepository.findById(applicationId).get();
        application.setApplicationStatus(newApplicationStatus);
        applicationRepository.save(application);
        return application;
    }

    @Override
    public Application getApplicationById(Long applicationId) {
        return applicationRepository.findById(applicationId).get();
    }
}