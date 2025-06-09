/*
https://www.chiark.greenend.org.uk/~sgtatham/puzzles/js/guess.html
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mastermind {

    public static int[] generateCode(int code_length,int domain) {
        Random rand = new Random();
        int[] code = new int[code_length];
        for (int i = 0; i < code_length; i++) {
            code[i] = rand.nextInt(1,domain + 1);
        }
        return code;
    }

    public static int promptForInt(Scanner s,String prompt,int min,int max) {
        boolean isValidInput = false;
        int answer = -1;
        while (!isValidInput) {
            System.out.print(prompt);
            if (s.hasNextInt()) {
                answer = s.nextInt();
                s.nextLine(); // clear out the input stream
                // check that it's in range
                if (answer >= min && answer <= max) {
                    isValidInput = true;
                } else {
                    System.out.println("Number must be between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Please enter an integer.");
                s.nextLine(); // clear the input stream
            }
        }
        return answer;
    }

    // pre: n is a code_length digit integer
    public static int[] int2Array(int code_length,int n) {
        int[] result = new int[code_length];
        for (int i = code_length - 1; i >= 0; i--) {
            result[i] = n % 10;
            n /= 10;
        }
        return result;
    }

    public static int[] getGuess(Scanner s,String prompt,int codeLength,int domain) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < codeLength; i++) {
            min += Math.pow(10,i);
            max += domain * Math.pow(10,i);
        }

        boolean isValidDomain = false;
        int[] userGuess = new int[codeLength];
        while (!isValidDomain) {
            int userGuessInt = promptForInt(s,prompt,min,max);
            userGuess = int2Array(codeLength,userGuessInt);
            // check the domain of the guess
            isValidDomain = true;
            for (int i = 0; i < userGuess.length; i++) {
                if (userGuess[i] < 1 || userGuess[i] > domain) {
                    System.out.println("Each digit must be between 1 and " + domain + ".");
                    isValidDomain = false;
                    break;
                }
            }
        }
        return userGuess;

    }

    public static String code2String(int[] code) {
        String result = "";
        for (int i = 0; i < code.length; i++) {
            result += code[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get the game parameters from the user
        int codeLength = 4;
        int domain = 6;         // number of "colors"
        int guessesAllowed = 12;

        // generate a random code
        int[] code = generateCode(codeLength,domain);
//        int[] code = {3, 1, 3, 5};
//        System.out.println(Arrays.toString(code));

        int numOfGuesses = 0;
        while (numOfGuesses < guessesAllowed) {
            // get the user's guess
            numOfGuesses++;
            String prompt = "Enter your " + codeLength + " digit guess (" + numOfGuesses + "/" + guessesAllowed + "): ";
            int[] guess = getGuess(scanner,prompt,codeLength,domain);

            // count pegs

            int blackPegs = 0;
            int whitePegs = 0;

            // count the "black pegs"
            for (int i = 0; i < codeLength; i++) {
                if (guess[i] == code[i]) { // found a black peg
                    blackPegs++;
                }
            }

            // count the "white pegs"
            boolean[] isCounted = new boolean[code.length]; // keep track of code digits already counted
            for (int i = 0; i < guess.length; i++) {        // loop through the guess
                if (guess[i] == code[i]) continue;          // skip if guess digit is black peg
                for (int j = 0; j < code.length; j++) {     // loop through the code
                    if (guess[i] == code[j]                 // if there is a match
                            && code[j] != guess[j]          // and code digit is not a black peg
                            && !isCounted[j]) {             // and hasn't already been counted
                        isCounted[j] = true;                // mark as counted
                        whitePegs++;                        // increment counter
                        break;                              // stop trying to match this guess digit
                    }
                }
            }

            System.out.println("Black pegs: " + blackPegs);
            System.out.println("White pegs: " + whitePegs);

            // Determine if win or lose
            if (blackPegs == codeLength) { // WIN!!!
                System.out.println("You guessed the code in " + numOfGuesses + " guesses!");
                numOfGuesses = guessesAllowed;
            } else if (numOfGuesses >= guessesAllowed) { // LOSE :(
                System.out.println("You lose :( The code was " + code2String(code) + ".");
            }
        }
    }
}
