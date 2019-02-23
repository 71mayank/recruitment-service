package za.co.bookstore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.bookstore.dao.BookDAOImpl;
import za.co.bookstore.dto.BookDTO;
import za.co.bookstore.model.Book;
import za.co.bookstore.response.BookResponse;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAOImpl bookDAOImpl;


    @Override
    public ResponseEntity<BookResponse> saveBook(BookDTO bookDTO) {
        Book book = new Book();
        bookDAOImpl.saveBook(book);
        return new ResponseEntity<>(new BookResponse(), HttpStatus.OK);
    }


}
