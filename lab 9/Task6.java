// целое слово ищем

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the input text
        System.out.println("Enter the text (press Enter on a blank line to finish):");
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
            System.out.println("You did not enter anything. Exiting the program.");
            return;
        }
        
        String text = textBuilder.toString().trim(); // удаляет начальные и конечные пробелы
        
        // Read the keyword
        System.out.println("Enter the keyword:");
        String keyword = scanner.nextLine();
        
        // if the keyword is empty
        if (keyword.isEmpty()) {
            System.out.println("You did not enter a keyword. Exiting the program.");
            return;
        }
        
        // Split the text into sentences
        String[] sentences = text.split("[.!?]\\s*");
        
        // Compile the regex pattern for the keyword
        Pattern pattern = Pattern.compile("\\b" + Pattern.quote(keyword) + "\\b"); // чтоб символы нормально воспринимались
        
        // Collect and print matching sentences
// ищем совпадения
        for (String sentence : sentences) {
            Matcher matcher = pattern.matcher(sentence);
            if (matcher.find()) {
                System.out.println(sentence);
            }
        }
    }
}