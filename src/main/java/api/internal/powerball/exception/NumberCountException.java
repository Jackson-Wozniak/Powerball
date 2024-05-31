package api.internal.powerball.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Must be 5 main numbers & 1 powerball given")
public class NumberCountException extends RuntimeException{
}
