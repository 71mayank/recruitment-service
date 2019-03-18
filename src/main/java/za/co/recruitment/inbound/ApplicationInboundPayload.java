package za.co.recruitment.inbound;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "relatedOffer",
        "candidateEmail",
        "resumeText",
        "applicationStatus"
})

public class ApplicationInboundPayload {

    @JsonProperty("relatedOffer")
    @NotNull(message = "relatedOffer cannot be null")
    @Min(value = 1, message = "relatedOffer should be greater than 0")
    private Long relatedOffer;

    @JsonProperty("candidateEmail")
    @Email(message = "candidateEmail should be valid")
    private String candidateEmail;

    @JsonProperty("resumeText")
    @NotNull(message = "resumeText cannot be null")
    @Size(min = 5, max = 200, message = "resumeText must be between 5 and 200 characters")
    private String resumeText;

    @JsonProperty("applicationStatus")
    private String applicationStatus;

}
