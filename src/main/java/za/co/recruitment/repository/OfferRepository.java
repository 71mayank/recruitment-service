package za.co.recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.co.recruitment.model.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("SELECT o FROM Offer o WHERE o.jobTitle = :jobTitle")
    Offer getOfferByJobTitle(String jobTitle);
}
