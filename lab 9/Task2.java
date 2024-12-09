// расшифруйте слова наоборот, разделённые пробелом

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String text = scanner.nextLine();
        
         // пустой ввод
        if (text.isEmpty()) {
            System.out.println("Пустой ввод.");
            return;
        }
        
        String[] words = text.split(" ");
        StringBuilder decodedMessage = new StringBuilder();
        for (String word : words) {
            decodedMessage.append(new StringBuilder(word).reverse().toString());
            decodedMessage.append(" ");
        }
        System.out.println("Decoded message: " + decodedMessage.toString().trim()); // удаляем пробелы
    }
}