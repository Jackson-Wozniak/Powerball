package api.internal.powerball.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidRangeException.class)
    public ResponseEntity<String> handleInvalidRange(InvalidRangeException ex){
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }

    @ExceptionHandler(NumberCountException.class)
    public ResponseEntity<String> handleIncorrectCount(NumberCountException ex){
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }

    @ExceptionHandler(DuplicateDrawingException.class)
    public ResponseEntity<String> handleIncorrectCount(DuplicateDrawingException ex){
        return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
    }
}
