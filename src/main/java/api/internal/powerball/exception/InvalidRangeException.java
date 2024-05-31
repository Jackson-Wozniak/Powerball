package api.internal.powerball.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST,
        reason = "One of more numbers are not in range 1-69, or powerball is not in range 1-26")
public class InvalidRangeException extends RuntimeException{
}
