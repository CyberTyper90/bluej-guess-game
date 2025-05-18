// GameModel.java
import java.util.Random;

public class GameModel {
    private int numberToGuess;
    private int maxNumber;
    private int tries;
    private Random random;

    public GameModel(int difficultyMaxNumber) {
        this.maxNumber = difficultyMaxNumber;
        this.random = new Random();
        resetGame();
    }

    public void resetGame() {
        this.numberToGuess = random.nextInt(maxNumber) + 1;
        this.tries = 0;
    }

    public int guess(int playerGuess) {
        tries++;
        if (playerGuess < numberToGuess) {
            return -1; // too low
        } else if (playerGuess > numberToGuess) {
            return 1; // too high
        } else {
            return 0; // correct
        }
    }

    public int getTries() {
        return tries;
    }

    public int getNumberToGuess() {
        return numberToGuess;
    }

    public int getMaxNumber() {
        return maxNumber;
    }
}
