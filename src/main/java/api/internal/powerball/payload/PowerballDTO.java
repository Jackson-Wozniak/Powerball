package api.internal.powerball.payload;

import api.internal.powerball.model.Powerball;
import api.internal.powerball.model.Prizes;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PowerballDTO {

    private int[] guesses;
    private int[] winningNumbers;
    private int winnings;
    private Prizes prizes;

    public PowerballDTO(Powerball powerball){
        this.guesses = powerball.getGuesses();
        this.winningNumbers = powerball.getWinningNumbers();
        this.winnings = powerball.getWinnings();
        this.prizes = powerball.getPrizes();
    }
}
