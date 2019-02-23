package za.co.bookstore.response;

import lombok.Getter;
import lombok.Setter;
import za.co.bookstore.dto.BookDTO;

@Getter
@Setter
public class BookResponse {
    private String responseMessage;
    private BookDTO bookDTO;
}
