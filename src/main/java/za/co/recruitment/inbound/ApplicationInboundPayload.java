package za.co.recruitment.inbound;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
    private String relatedOffer;

    @JsonProperty("candidateEmail")
    private String candidateEmail;

    @JsonProperty("resumeText")
    private String resumeText;

    @JsonProperty("applicationStatus")
    private String applicationStatus;

}
