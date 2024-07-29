import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;


public class Hangman {
    public static void main (String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("/Users/jonsmacbookair/Documents/HangmanWords.txt"));

        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }

    }
}