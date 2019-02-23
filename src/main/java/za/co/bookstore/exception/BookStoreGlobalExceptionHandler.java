package za.co.bookstore.exception;


import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BookStoreGlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(BookNotFoundException ex, WebRequest request) {
        BookStoreErrorDetails bookStoreErrorDetails = new BookStoreErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(bookStoreErrorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        BookStoreErrorDetails bookStoreErrorDetails = new BookStoreErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(bookStoreErrorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

