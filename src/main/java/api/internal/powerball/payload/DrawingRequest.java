package api.internal.powerball.payload;

import api.internal.powerball.exception.InvalidRangeException;
import api.internal.powerball.exception.NumberCountException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DrawingRequest {

    private int[] mainNumbers;
    private int powerball;

    public DrawingRequest(int[] mainNumbers, int powerball){
        this.mainNumbers = mainNumbers;
        this.powerball = powerball;
    }

    public void verifyNumbers(){
        if(mainNumbers.length != 5) throw new NumberCountException();
        for(int i = 0; i <= 5; i++){
            if(mainNumbers[i] < 1 || mainNumbers[i] > 69) throw new InvalidRangeException();
        }
        if(powerball < 1 || powerball > 26) throw new InvalidRangeException();
    }
}
