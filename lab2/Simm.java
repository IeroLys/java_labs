import java.util.Random;
import java.util.Arrays;

public class Simm {
    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();

        // Заполнение массива числами от 0 до 1000
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1001); // от 0 до 1000
        }

        // Вывод массива
        /*System.out.println("Массив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();*/
        
        System.out.println("Исходный массив: " + Arrays.toString(array));

        int count = 0;
        int sum = 0;

        // Подсчет трехзначных симметричных чисел
        for (int num : array) {
            if (isThreeDigitSymmetric(num)) {
                count++;
                sum += num;
            }
        }

        // Вывод результатов
        System.out.println("Количество трехзначных симметричных чисел: " + count);
        System.out.println("Сумма трехзначных симметричных чисел: " + sum);
    }

    // Метод для проверки, является ли число трехзначным симметричным
    private static boolean isThreeDigitSymmetric(int num) {
        if (num >= 100 && num <= 999) { // Проверка на трехзначность
            String strNum = String.valueOf(num);
            return strNum.charAt(0) == strNum.charAt(2); // Проверка симметричности
        }
        return false;
    }
}
