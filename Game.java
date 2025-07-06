import java.util.ArrayList;
import java.util.Random;


public abstract class Game {
    protected int targetNumber;
    protected int maxAttempts;
    protected ArrayList<Integer> guessHistory;

    public Game() {
        this.targetNumber = new Random().nextInt(100) + 1;
        this.maxAttempts = 8;
        this.guessHistory = new ArrayList<>();
    }

    protected abstract void showResult(boolean won);
}
