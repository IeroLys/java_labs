//трёхбуквенные слова ищем
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the sentence: ");
        String sentence = scanner.nextLine();
        
         // if the input is empty
        if (sentence.isEmpty()) {
            System.out.println("You did not enter anything. Exiting the program.");
            return;
        }
        
        String[] words = sentence.split("[ ,]+");
        int count = 0;
        for (String word : words) {
            if (word.length() == 3) {
                count++;
            }
        }
        System.out.println("Number of three-letter words: " + count);
    }
}