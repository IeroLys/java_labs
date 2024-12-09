// сумма целых чисел в тексте

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String text = scanner.nextLine();
        
         // пустой ввод
        if (text.isEmpty()) {
            System.out.println("Пустой ввод.");
            return;
        }
        
        // создаём шаблон для поиска
        Pattern pattern = Pattern.compile("\\d+");
       // создаём объект для поиска в тексте по шаблону
        Matcher matcher = pattern.matcher(text);
        int sum = 0;
        while (matcher.find()) { // пока есть нужные вхождения
            sum += Integer.parseInt(matcher.group()); // group Возвращает текст, соответствующий найденному шаблону.
        }
        System.out.println("Сумма всех целых чисел: " + sum);
    }
}