import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DoubleOperations {
    private LinkedList<Double> doubleList;

    public DoubleOperations() {
        doubleList = new LinkedList<>();
        
// ввод и проверки

System.out.println("Введите действительные числа. Для окончания ввода нажмите Enter.");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                try {
                    double num = Double.parseDouble(line);
                    doubleList.add(num);
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат числа. Введите действительное число.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Проверка на пустой список
        if (doubleList.isEmpty()) {
            System.out.println("Список пуст. Завершение работы.");
            return;
        }
    }

// выполняем задания
// сортируем по убыванию
    public void sortDescending() {
        doubleList.sort((a, b) -> Double.compare(b, a));
        System.out.println("Список, отсортированный по убыванию: " + doubleList);
    }

// содержит ли 0
    public void checkForZeros() {
        boolean hasZeros = doubleList.contains(0.0);
        System.out.println("Содержит нулевые элементы: " + hasZeros);
    }

// добавить в середину списка элемент равный среднему ариф. между первым и последним элементом
    public void addAverageToMiddle() {
        double first = doubleList.getFirst();
        double last = doubleList.getLast();
        double average = (first + last) / 2.0;
        int middleIndex = doubleList.size() / 2;
        doubleList.add(middleIndex, average);
        System.out.println("Список после добавления среднего значения: " + doubleList);
    }

    public static void main(String[] args) {
        DoubleOperations dobj = new DoubleOperations();
        if (!dobj.doubleList.isEmpty()) {
// вызываем функции
            dobj.sortDescending();
            dobj.checkForZeros();
            dobj.addAverageToMiddle();
        }
    }
}