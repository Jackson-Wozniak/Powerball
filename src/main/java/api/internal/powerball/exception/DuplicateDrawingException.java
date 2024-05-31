package api.internal.powerball.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DuplicateDrawingException extends RuntimeException{
    private final HttpStatus status = HttpStatus.BAD_REQUEST;
    private final int duplicate;

    public DuplicateDrawingException(int duplicate) {
        this.duplicate = duplicate;
    }

    @Override
    public String getMessage(){
        return duplicate + " guessed more than once";
    }
}
