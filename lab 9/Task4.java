// пароль

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        
         // пустой ввод
        if (password.isEmpty()) {
            System.out.println("Пустой ввод.");
            return;
        }
        
        boolean hasUpper = password.matches(".*[A-Z].*"); // хотя бы 1 заглавная
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasSpecial = password.matches(".*[#@\\$%\\^&*<>].*"); // чтоб были такие символы
        boolean hasPunctuation = password.matches(".*[.,;:'\"!?-].*");
        boolean lengthValid = password.length() >= 8 && password.length() <= 12;
        
        if (hasUpper && hasLower && hasSpecial && hasPunctuation && lengthValid) {
            System.out.println("Хороший пароль.");
        } else {
            System.out.println("Не очень, отсутствует вот это:");
            if (!hasUpper) {
                System.out.println("- Заглавные буквы");
            }
            if (!hasLower) {
                System.out.println("- Маленькие буквы");
            }
            if (!hasSpecial) {
                System.out.println("- Спец. символы (#, @, $, %, ^, &, *, <, >)");
            }
            if (!hasPunctuation) {
                System.out.println("- Знаки препинания (.,;:'\"!?-)");
            }
            if (!lengthValid) {
                System.out.println("- Необходимая длина (8 - 12 символов)");
            }
        }
    }
}