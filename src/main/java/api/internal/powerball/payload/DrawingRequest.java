package api.internal.powerball.payload;

import api.internal.powerball.exception.DuplicateDrawingException;
import api.internal.powerball.exception.InvalidRangeException;
import api.internal.powerball.exception.NumberCountException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class DrawingRequest {

    private int[] numbers;
    private int powerball;

    public void verifyNumbers(){
        if(numbers.length != 5) throw new NumberCountException(numbers.length);
        for(int i = 0; i < 5; i++){
            int num = numbers[i];
            if(num < 1 || num > 69) throw new InvalidRangeException(num, false);
        }
        if(powerball < 1 || powerball > 26) throw new InvalidRangeException(powerball, true);

        checkForDuplicates();
    }

    private void checkForDuplicates(){
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(powerball, true);
        for(int i = 0; i < 5; i++){
            if(map.containsKey(numbers[i])) throw new DuplicateDrawingException(numbers[i]);
            map.put(numbers[i], true);
        }
    }
}
