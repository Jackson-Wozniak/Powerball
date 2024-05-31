package api.internal.powerball.model;

import api.internal.powerball.payload.DrawingRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class Powerball {

    private final int[] guesses = new int[6];
    private final int[] winningNumbers = new int[6];
    private int winnings;
    private Prizes prizes;
    private static final Random random = new Random();

    public Powerball(DrawingRequest request){
        System.arraycopy(request.getNumbers(), 0, guesses, 0, 5);
        guesses[5] = request.getPowerball();

        drawWinners();
        this.prizes = new Prizes();
        matchToPrizes();
    }

    private void drawWinners(){
        ArrayList<Integer> list = new ArrayList<>();

        while(list.size() < 5){
            int rand = random.nextInt(69) + 1;
            if(!list.contains(rand)) list.add(rand);
        }
        while(true){
            int rand = random.nextInt(26) + 1;
            if(!list.contains(rand)){
                list.add(rand);
                break;
            }
        }
        for(int i = 0; i < 6; i++){
            winningNumbers[i] = list.get(i);
        }
    }

    private void matchToPrizes(){
        boolean hasPowerball = winningNumbers[5] == guesses[5];
        int matching = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(guesses[i] == winningNumbers[j]){
                    matching++;
                    break;
                }
            }
        }
        this.winnings = prizes.matchToPrize(matching, hasPowerball);
    }
}
