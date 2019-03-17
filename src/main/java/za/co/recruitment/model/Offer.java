package za.co.recruitment.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "OFFER")
@Builder
@AllArgsConstructor
@Entity
public class Offer {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "JOB_TITLE")
    private String jobTitle;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;

    @Column(name = "NO_OF_APPLICATIONS")
    private Long numberOfApplications;

}