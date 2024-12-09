// пароль

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the password: ");
        String password = scanner.nextLine();
        
         // if the input is empty
        if (password.isEmpty()) {
            System.out.println("You did not enter anything. Exiting the program.");
            return;
        }
        
        boolean hasUpper = password.matches(".*[A-Z].*"); // хотя бы 1 заглавная
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasSpecial = password.matches(".*[#@\\$%\\^&*<>].*");
        boolean hasPunctuation = password.matches(".*[.,;:'\"!?-].*");
        boolean lengthValid = password.length() >= 8 && password.length() <= 12;
        
        if (hasUpper && hasLower && hasSpecial && hasPunctuation && lengthValid) {
            System.out.println("Password is good.");
        } else {
            System.out.println("Password is not good because it lacks:");
            if (!hasUpper) {
                System.out.println("- Uppercase letters");
            }
            if (!hasLower) {
                System.out.println("- Lowercase letters");
            }
            if (!hasSpecial) {
                System.out.println("- Special symbols (#, @, $, %, ^, &, *, <, >)");
            }
            if (!hasPunctuation) {
                System.out.println("- Punctuation marks (.,;:'\"!?-)");
            }
            if (!lengthValid) {
                System.out.println("- Proper length (8 to 12 characters)");
            }
        }
    }
}