package api.internal.powerball.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NumberCountException extends RuntimeException{
    private final HttpStatus status = HttpStatus.BAD_REQUEST;
    private final int count;

    public NumberCountException(int count) {
        this.count = count;
    }

    @Override
    public String getMessage(){
        return "Expected 5 main numbers, but received " + count;
    }
}
