/*
 *Заполнить двумерный массив (матрицу) 8 x 8 целыми числами (диапазон  
чисел от -10 до 10). Элемент матрицы называется локальным минимумом,  
если он строго меньше всех четырех соседних элементов. Посчитать  
количество локальных минимумов в матрице и вывести их на печать  
вместе с индексами.
 */

import java.util.Random;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[8][8];
        Random random = new Random();

        // Заполнение матрицы случайными числами
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(21) - 10; // Генерация случайного числа от -10 до 10
            }
        }

        // Поиск всех локальных минимумов в матрице
        int localMinimumCount = 0;
        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[i].length - 1; j++) {
                int currentElement = matrix[i][j];
                int topElement = matrix[i - 1][j];
                int leftElement = matrix[i][j - 1];
                int rightElement = matrix[i][j + 1];
                int bottomElement = matrix[i + 1][j];

                boolean isLocalMinimum = currentElement < topElement &&
                                         currentElement < leftElement &&
                                         currentElement < rightElement &&
                                         currentElement < bottomElement;

                if (isLocalMinimum) {
                    System.out.println("Локальный минимум: " + currentElement + ", индексы: [" + i + "][" + j + "]");
                    localMinimumCount++;
                }
            }
        }

        System.out.println("Количество локальных минимумов в матрице: " + localMinimumCount);
    }
}
