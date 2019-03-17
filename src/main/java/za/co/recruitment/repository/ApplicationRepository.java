package za.co.recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.recruitment.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
