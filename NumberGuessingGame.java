import java.util.*;

public class NumberGuessingGame {
    static ArrayList<Integer> scoreBoard = new ArrayList<Integer>();

    public static void main(String[] args) {
        NumberGuessingGame methodChange = new NumberGuessingGame();
        methodChange.menu(scoreBoard);
    }

    public void menu(ArrayList<Integer> scoreBoard) {
        NumberGuessingGame methodChange = new NumberGuessingGame();
        Scanner input = new Scanner(System.in);

        while (true) { // Loop to keep the menu running until user chooses to exit
            System.out.println("~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Welcome to the Number Guessing game.");
            System.out.println("Select one of the options below (1-4):");
            System.out.println("1) Play the Game");
            System.out.println("2) Score Board");
            System.out.println("3) Display Instructions");
            System.out.println("4) Exit the game");
            System.out.println("~~~~~~~~~~~~~~~~~~~~");

            try {
                System.out.print("What action would you like to do from the above actions? ");
                int menuOption = input.nextInt();
                switch (menuOption) {
                    case 1:
                        System.out.print("\n" + "What would you like the range of the numbers to be? ");
                        int numberRange = input.nextInt();
                        int randomNumber = methodChange.randomNumber(numberRange);
                        methodChange.guessNumber(randomNumber);
                        break;
                    case 2:
                        methodChange.displayScoreBoard();
                        break;
                    case 3:
                        System.out.println("The fun and easy project “Guess the Number” is a short Java project that allows the user to guess the number generated by the computer & involves the following steps:");
                        System.out.println("1. The system generates a random number from a given range, say 1 to 100.");
                        System.out.println("2. You will be prompted to enter their given number in a displayed dialogue box.");
                        System.out.println("3. The computer then tells if the entered number matches the guessed number or it is higher/lower than the generated number.");
                        System.out.println("4. You can also display the score at the end.");
                        break;
                    case 4:
                        System.out.println("\n" + "Thanks for playing the game!");
                        System.exit(0);
                        break;
                    default:
                        throw new InputMismatchException("Enter a Valid number.");
                }
            } catch (InputMismatchException e) {
                System.err.println("\n" + e.getMessage() + "\n");
            }
        }
    }

    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }

    public void guessNumber(int randomNumber) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Enter your guess number: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > randomNumber) {
                System.out.println("Lower");
            } else if (userGuess < randomNumber) {
                System.out.println("Higher");
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You answered the number correctly in " + guess + " try!");
        } else {
            System.out.println("You answered the number correctly in " + guess + " tries!");
        }
        scoreBoard.add(guess);
        System.out.println(" ");
    }

    public void displayScoreBoard() {
        System.out.println("--------------------");
        System.out.println("Score Board");
        System.out.println("--------------------");
        System.out.println("Your fastest games today out of all tries is: " + "\n");
        Collections.sort(scoreBoard);
        for (Integer scores : scoreBoard) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
    }
}
