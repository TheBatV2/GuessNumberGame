import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GuessTheNumberGame extends Game implements Guessable {

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean hasWon = false;

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("I have chosen a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts.");

        for (int i = 0; i < maxAttempts; i++) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            guessHistory.add(guess);

            if (guess == targetNumber) {
                System.out.println("Correct! You've won!");
                hasWon = true;
                break;
            } else if (guess < targetNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
        }

        showResult(hasWon);
        scanner.close();
    }

    @Override
    protected void showResult(boolean won) {
        System.out.println("Game over!");
        System.out.println("The number was: " + targetNumber);
        System.out.println("Your guesses: " + guessHistory);

        try (FileWriter writer = new FileWriter("results.txt", true)) {
            writer.write("Game result: " + (won ? "Won" : "Lost") + "\n");
            writer.write("Target number: " + targetNumber + "\n");
            writer.write("Guesses: " + guessHistory + "\n\n");
        } catch (IOException e) {
            System.out.println("Failed to write to results file.");
        }
    }
}
