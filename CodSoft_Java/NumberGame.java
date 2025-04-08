import java.util.Random;
import java.util.Scanner;
public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        final int MAX_ATTEMPTS = 5;
        final int MIN = 1;
        final int MAX = 100;
        boolean playAgain = true;
        System.out.println("=== Welcome to the Guess the Number Game! ===");
        while (playAgain) {
            int target = random.nextInt(MAX - MIN + 1) + MIN;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;
            System.out.println("\nI'm thinking of a number between " + MIN + " and " + MAX + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");
            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess;
                if (!scanner.hasNextInt()) {
                    System.out.println("That's not a valid number! Try again.");
                    scanner.next(); 
                    continue;
                }
                guess = scanner.nextInt();
                if (guess == target) {
                    System.out.println("Correct! You guessed the number!");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < target) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
                attemptsLeft--;
                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }
            if (!guessedCorrectly) {
                System.out.println("You're out of attempts. The correct number was: " + target);
            }
            System.out.print("\nDo you want to play another round? (yes/no): ");
            scanner.nextLine(); 
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }
        System.out.println("\nThanks for playing! Your total score: " + score);
        System.out.println("Goodbye!");
        scanner.close();
    }
}
