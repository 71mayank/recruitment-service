package za.co.recruitment.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.recruitment.model.Offer;
import java.time.LocalDateTime;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OfferRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OfferRepository offerRepository;

    @Test
    public void whenSaveOffer_thenReturnOffer() {
        // given
        Offer offer = buildOffer();
        entityManager.persist(offer);
        entityManager.flush();
        // when
        Optional<Offer> found = offerRepository.findById(offer.getId());
        // then
        String jobTitle = found.get().getJobTitle();
        assertThat(jobTitle).isEqualTo("SDE");
    }

    private Offer buildOffer() {
        return Offer.builder()
                .jobTitle("SDE")
                .startDate(LocalDateTime.now())
                .numberOfApplications(3L).build();
    }

    //TODO Cover all repository database queries and transaction


}


