package za.co.bookstore.service;

import org.springframework.http.ResponseEntity;
import za.co.bookstore.dto.BookDTO;
import za.co.bookstore.model.Book;
import za.co.bookstore.response.BookResponse;

import java.util.List;

public interface BookService {
    ResponseEntity<BookResponse> saveBook(BookDTO bookDTO);

    List<Book> getAllBooks();
}
