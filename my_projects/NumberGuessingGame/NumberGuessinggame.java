package guess_number;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessinggame {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random random = new Random();
        
        int secretNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int guess;
        boolean guessedCorrectly = false;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        
        while (!guessedCorrectly) {
            System.out.print("Enter your guess: ");
            guess = scn.nextInt();
            attempts++;
            
            if (guess == secretNumber) {
                guessedCorrectly = true;
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }
        
        System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly in " + attempts + " attempts.");
    }
}
