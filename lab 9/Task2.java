// расшифруйте слова наоборот, разделённые пробелом

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the encoded text: ");
        String text = scanner.nextLine();
        
         // if the input is empty
        if (text.isEmpty()) {
            System.out.println("You did not enter anything. Exiting the program.");
            return;
        }
        
        String[] words = text.split(" ");
        StringBuilder decodedMessage = new StringBuilder();
        for (String word : words) {
            decodedMessage.append(new StringBuilder(word).reverse().toString());
            decodedMessage.append(" ");
        }
        System.out.println("Decoded message: " + decodedMessage.toString().trim());
    }
}