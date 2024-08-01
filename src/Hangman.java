import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.File;


public class Hangman {
    public static void main (String[] args) throws FileNotFoundException {


        Scanner scanner = new Scanner(new File("/Users/jonsmacbookair/Documents/HangmanWords.txt"));
        Scanner keyboard = new Scanner(System.in);

        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.nextLine());

        }

        Random rand = new Random();

        String word = words.get(rand.nextInt(words.size()));
        System.out.println(word);

        List<Character> playerGuesses = new ArrayList<>();

        printWordState(word, playerGuesses);

        while(true) {
            getPlayerGuess(keyboard, word, playerGuesses);
           if  (printWordState(word, playerGuesses)) {
               break;
           }
        }
        System.out.println("You win!");
    }

        private static boolean getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
            System.out.println("Please enter a letter:");
            String letterGuess = keyboard.nextLine();
            playerGuesses.add(letterGuess.charAt(0));

            return word.equals(letterGuess);
        }
        private static boolean printWordState(String word, List<Character> playerGuesses) {
                int correctCount = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (playerGuesses.contains(word.charAt(i))) {
                        System.out.print(word.charAt(i));
                        correctCount++;
                    } else {
                        System.out.print(" - ");
                    }
                }
                System.out.println();
                return (word.length() == correctCount);
            }
        }

