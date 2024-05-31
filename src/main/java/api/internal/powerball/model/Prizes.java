package api.internal.powerball.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Prizes {

    private final int powerball = 4;
    private final int powerballPlusOne = 4;
    private final int powerballPlusTwo = 7;
    private final int threeMatch = 7;
    private final int powerballPlusThree = 100;
    private final int fourMatch = 100;
    private final int powerballPlusFour = 50_000;
    private final int fiveMatch = 1_000_000;
    private int jackpot;

    public int matchToPrize(int matchingNumbers, boolean hasPowerball){
        return switch (matchingNumbers){
            case 1 -> hasPowerball ? powerballPlusOne : 0;
            case 2 -> hasPowerball ? powerballPlusTwo : 0;
            case 3 -> hasPowerball ? powerballPlusThree : threeMatch;
            case 4 -> hasPowerball ? powerballPlusFour : fourMatch;
            case 5 -> hasPowerball ? jackpot : fiveMatch;
            default -> 0;
        };
    }
}
