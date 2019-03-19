package za.co.recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import za.co.recruitment.model.Application;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    @Query("SELECT a FROM Application a WHERE a.relatedOffer = :offerId")
    List<Application> getApplicationsByOfferId(@Param("offerId") Long offerId);

    @Query("SELECT a FROM Application a WHERE a.id = :applicationId AND a.relatedOffer = :offerId")
    Application getApplicationByIdPerOffer(@Param("applicationId") Long applicationId,@Param("offerId") Long offerId);

    @Query("SELECT a FROM Application a WHERE a.candidateEmail = :candidateEmail AND a.relatedOffer = :offerId")
    Application getApplicationByEmailPerOffer(@Param("candidateEmail") String candidateEmail, @Param("offerId") Long offerId);

}
