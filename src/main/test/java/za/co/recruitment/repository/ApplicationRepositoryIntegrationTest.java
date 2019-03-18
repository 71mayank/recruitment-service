package za.co.recruitment.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.recruitment.enumeration.ApplicationEnum;
import za.co.recruitment.model.Application;
import za.co.recruitment.model.Offer;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ApplicationRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Test
    public void whenSaveApplication_thenReturnApplication() {
        // given
        Application application = buildApplication();
        entityManager.persist(application);
        entityManager.flush();
        // when
        Optional<Application> found = applicationRepository.findById(application.getId());
        // then
        Long jobTitle = found.get().getRelatedOffer();
        assertThat(jobTitle).isEqualTo(1L);
    }

    private Application buildApplication() {
        return Application.builder()
                .resumeText("This is a resume Text")
                .candidateEmail("71mayak@gmail.com")
                .applicationStatus(ApplicationEnum.APPLIED.name())
                .relatedOffer(1L).build();
    }

    //TODO Cover all repository database queries and transaction

}


