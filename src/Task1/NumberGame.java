package Task1;
import java.util.Scanner;
import java.util.Random;
public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random= new Random();
        int numberToGuess = random.nextInt(100)+1; //random number between 1 to 100
        int numberOfTries = 0;
        int guess;
        boolean win = false;
        System.out.println("Welcome to the Number Guessing Game");
        System.out.println("Iam thinking of a number between 1 to 100");
        System.out.println("Can you guess it");
        while (!win){
            System.out.println("Enter your guess: ");
            guess = sc.nextInt();
            numberOfTries++;

            if(guess < numberToGuess){
                System.out.println("Too low! Try again.");
            }else if (guess > numberToGuess){
                System.out.println("To high! Try again.");
            }else{
                win = true;
                System.out.println("Congratulation! You've guessed the number in "+numberOfTries+ "tries");
            }
        }
        sc.close();

    }
}
