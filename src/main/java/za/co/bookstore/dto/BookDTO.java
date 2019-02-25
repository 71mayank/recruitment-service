package za.co.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
        "category",
        "title",
        "title_lang",
        "year",
        "price",
        "authors"
})
public class BookDTO {
    @JsonProperty("category")
    private String category;

    @JsonProperty("title")
    private String title;

    @JsonProperty("title_lang")
    private String title_lang;

    @JsonProperty("year")
    private Long year;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("authors")
    private String authorDTOS;
}
