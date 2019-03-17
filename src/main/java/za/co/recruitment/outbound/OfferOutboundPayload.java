package za.co.recruitment.outbound;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
    @JsonProperty("jobTitle")
    private String jobTitle;

    @JsonProperty("startDate")
    private String startDate;

    @JsonProperty("numberOfApplications")
    private String numberOfApplications;

}
