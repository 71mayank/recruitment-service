package za.co.recruitment.inbound;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "jobTitle",
        "startDate",
        "numberOfApplications"
})
public class OfferInboundPayload {

    @JsonProperty("jobTitle")
    @NotNull(message = "jobTitle cannot be null")
    private String jobTitle;

    @JsonProperty("startDate")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @NotNull(message = "startDate cannot be null")
    private LocalDateTime startDate;

    @JsonProperty("numberOfApplications")
    @NotNull(message = "numberOfApplications cannot be null")
    @Min(value = 1, message = "numberOfApplications should be greater than 0")
    @Max(value = 9999999, message = "numberOfApplications should not be greater than 9999999")
    private Long numberOfApplications;

}
