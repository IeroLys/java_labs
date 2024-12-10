// одно слово - 10р
// предлог (1-2) - не считаем
// запятая - 10р
// сумма и строка без предлогов
// , - "зпт "

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Читаем ввод от пользователя
        System.out.println("Введите текст телеграммы:");
        String input = scanner.nextLine();
        
        // Разделяем текст на токены по пробелам и запятым
        String[] tokens = input.split("[ ,]+");
        
        StringBuilder transformedText = new StringBuilder();
        int wordCount = 0;
        
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue; // Пропускаем пустые токены
            }
            if (",".equals(token)) {
                transformedText.append("зпт ");
            } else if (token.length() > 2) {
                transformedText.append(token).append(" ");
                wordCount++;
            }
            // Слова длины 1 и 2 игнорируются
        }
        
        // Удаляем последний пробел
// если строка непустая, и посл.символ пробел
        if (transformedText.length() > 0 && transformedText.charAt(transformedText.length() - 1) == ' ') {
            transformedText.setLength(transformedText.length() - 1);
        }
        
        // Рассчитываем стоимость
        int cost = wordCount * 10;
        
        // Выводим результат
        System.out.println("Стоимость телеграммы: " + cost + " руб.");
        System.out.println("Преобразованный текст:");
        System.out.println(transformedText.toString());
    }
}