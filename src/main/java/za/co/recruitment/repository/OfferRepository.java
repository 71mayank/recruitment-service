package za.co.recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.recruitment.model.Offer;


public interface OfferRepository extends JpaRepository<Offer, Long> {
}
