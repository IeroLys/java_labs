//трёхбуквенные слова ищем
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Введите предложение: ");
        String sentence = scanner.nextLine();
        
         // пустой ввод
        if (sentence.isEmpty()) {
            System.out.println("Пустой ввод.");
            return;
        }
        
        String[] words = sentence.split("[ ,]+");
        int count = 0;
        for (String word : words) {
            if (word.length() == 3) {
                count++;
            }
        }
        System.out.println("Кол-во трёхбуквенных слов: " + count);
    }
}