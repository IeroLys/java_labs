// целое слово ищем

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст (нажмите Enter на пустой строке по завершению):");
        StringBuilder textBuilder = new StringBuilder();
        String line;
        boolean hasInput = false;
        while (true) {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            textBuilder.append(line).append("\n");
            hasInput = true;
        }
        
        // if the input is empty
        if (!hasInput) {
            System.out.println("Пустой ввод.");
            return;
        }
        
        String text = textBuilder.toString().trim(); // удаляет начальные и конечные пробелы
        
        System.out.println("Введите слово:");
        String keyword = scanner.nextLine();
        
        // пустой ввод
        if (keyword.isEmpty()) {
            System.out.println("Пустой ввод.");
            return;
        }
        
        // разделяем текст
        String[] sentences = text.split("[.!?]\\s*"); // в конце пробелы
        
        // создаём шаблон
        Pattern pattern = Pattern.compile("\\b" + Pattern.quote(keyword) + "\\b"); // чтоб символы нормально воспринимались
        

// ищем совпадения
        for (String sentence : sentences) {
            Matcher matcher = pattern.matcher(sentence);
            if (matcher.find()) {
                System.out.println(sentence);
            }
        }
    }
}