//удалить все заглавные буквы

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово: ");
        String word = scanner.nextLine();
        
         // пустой ввод
        if (word.isEmpty()) {
            System.out.println(" Пустой ввод.");
            return;
        }
        
        StringBuilder result = new StringBuilder();
        for (char c : word.toCharArray()) { // массив символов
            if (!Character.isUpperCase(c)) {
                result.append(c);
            }
        }
        System.out.println("Результат: " + result.toString());
    }
}