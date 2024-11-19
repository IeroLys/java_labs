// Заполнить массив 20 целыми числами
// (диапазон чисел от 0 до 1000).
// В массиве найти максимальное четное число.


import java.util.Random;
import java.util.Arrays;

public class max{
    public static void main(String[] args) {
        int[] array = new int[20];
        Random random = new Random();

        // Заполнение массива 20 целыми числами от 0 до 1000
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1001);
        }
        
        System.out.println(Arrays.toString(array));

        // Поиск максимального четного числа
        int maxEven = -1; // Начальное значение для максимального четного числа
        for (int num : array) {
            if (num % 2 == 0 && num > maxEven) {
                maxEven = num;
            }
        }

        // Результат
        if (maxEven != -1) {
            System.out.println("Максимальное четное число в массиве: " + maxEven);
        } else {
            System.out.println("Четных чисел в массиве нет.");
        }
    }
}