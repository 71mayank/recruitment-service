package za.co.recruitment.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "APPLICATION")
@AllArgsConstructor
@Builder
public class Application {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "RELATED_OFFER")
    private String relatedOffer;

    @Column(name = "CANDIDATE_EMAIL")
    private String candidateEmail;

    @Column(name = "RESUME_TEXT")
    private String resumeText;

    @Column(name = "APPLICATION_STATUS")
    private String applicationStatus;

}
