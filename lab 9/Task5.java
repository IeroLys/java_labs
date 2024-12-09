// сумма целых чисел в тексте

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String text = scanner.nextLine();
        
         // if the input is empty
        if (text.isEmpty()) {
            System.out.println("You did not enter anything. Exiting the program.");
            return;
        }
        
        Pattern pattern = Pattern.compile("\\d+"); // создаём pattern на основе регулярки
        Matcher matcher = pattern.matcher(text);
        int sum = 0;
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }
        System.out.println("Sum of all integers: " + sum);
    }
}