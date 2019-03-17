package za.co.recruitment.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RecruitmentErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
}
