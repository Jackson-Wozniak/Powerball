package api.internal.powerball.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidRangeException extends RuntimeException{
    private final HttpStatus status = HttpStatus.BAD_REQUEST;
    private final int outOfRange;
    private final boolean isPowerball;

    public InvalidRangeException(int outOfRange, boolean isPowerball) {
        this.outOfRange = outOfRange;
        this.isPowerball = isPowerball;
    }

    @Override
    public String getMessage(){
        if(isPowerball) return "Powerball out of range (1-26): " + outOfRange;
        return "Number out of range (1-69): " + outOfRange;
    }
}
