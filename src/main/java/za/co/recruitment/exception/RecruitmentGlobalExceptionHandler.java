package za.co.recruitment.exception;


import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RecruitmentGlobalExceptionHandler {

    @ExceptionHandler(OfferNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(OfferNotFoundException ex, WebRequest request) {
        RecruitmentErrorDetails recruitmentErrorDetails = new RecruitmentErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(recruitmentErrorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        RecruitmentErrorDetails recruitmentErrorDetails = new RecruitmentErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(recruitmentErrorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

