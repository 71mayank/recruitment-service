package za.co.recruitment.outbound;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

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

public class ApplicationOutboundPayload {

    @JsonProperty("relatedOffer")
    private String relatedOffer;

    @JsonProperty("candidateEmail")
    private String candidateEmail;

    @JsonProperty("resumeText")
    private String resumeText;

    @JsonProperty("applicationStatus")
    private String applicationStatus;

}
