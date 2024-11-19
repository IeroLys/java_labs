//Заполнить массив 20 целыми числами (диапазон чисел от 1 до 1000). 
//Образовать новый массив, элементами которого будут элементы 
//исходного массива, оканчивающиеся на цифру 3, отсортированные по 
//убыванию.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class End3 {
    public static void main(String[] args) {
        int[] originalArray = new int[20];
        Random random = new Random();

        // Заполнение исходного массива числами от 1 до 1000
        for (int i = 0; i < originalArray.length; i++) {
            originalArray[i] = random.nextInt(1000) + 1; // от 1 до 1000
        }

        // Вывод исходного массива
        System.out.println("Исходный массив: " + Arrays.toString(originalArray));

        // Формирование нового массива с элементами, оканчивающимися на 3
        ArrayList<Integer> newArrayList = new ArrayList<>();
        for (int num : originalArray) {
            if (num % 10 == 3) { // Проверка, оканчивается ли число на 3
                newArrayList.add(num);
            }
        }

        // Сортировка нового массива по убыванию
        Collections.sort(newArrayList, Collections.reverseOrder());

        // Преобразуем ArrayList обратно в массив
        Integer[] newArray = newArrayList.toArray(new Integer[0]);

        // Вывод нового массива
        if (newArray.length > 0) {
            System.out.println("Новый массив (числа, оканчивающиеся на 3, отсортированные по убыванию): " + Arrays.toString(newArray));
        } else {
            System.out.println("В исходном массиве нет чисел, оканчивающихся на 3.");
        }
    }
}
