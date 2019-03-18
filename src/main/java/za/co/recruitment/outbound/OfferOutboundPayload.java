package za.co.recruitment.outbound;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "jobTitle",
        "startDate",
        "numberOfApplications"
})
public class OfferOutboundPayload {

    @JsonProperty("offerId")
    private Long offerId;

    @JsonProperty("jobTitle")
    private String jobTitle;

    @JsonProperty("startDate")
    private LocalDateTime startDate;

    @JsonProperty("numberOfApplications")
    private Long numberOfApplications;

    @JsonProperty("responseMessage")
    private String responseMessage;

}
