//удалить все заглавные буквы

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String word = scanner.nextLine();
        
         // if the input is empty
        if (word.isEmpty()) {
            System.out.println("You did not enter anything. Exiting the program.");
            return;
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : word.toCharArray()) { // массив символов
            if (!Character.isUpperCase(c)) {
                result.append(c);
            }
        }
        System.out.println("Result: " + result.toString());
    }
}