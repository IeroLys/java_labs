import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class IntegerOperations {
    private ArrayList<Integer> intList;

    public IntegerOperations() {
        intList = new ArrayList<>();
       
// ввод
 System.out.println("Введите целые числа. Для окончания ввода нажмите Enter.");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                try {
                    int num = Integer.parseInt(line);
                    intList.add(num);
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат числа. Введите целое число.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Проверка на пустой список
        if (intList.isEmpty()) {
            System.out.println("Список пуст. Завершение работы.");
            return;
        }
    }

// поиск максимального
    public void findMaxValue() {
        int maxValue = intList.get(0);
        for (int num : intList) {
            if (num > maxValue) {
                maxValue = num;
            }
        }
        System.out.println("Максимальное значение: " + maxValue);
    }

// индекс последнего максимального
    public void findLastMaxIndex() {
        int maxValue = intList.get(0);
        int lastIndex = 0;
        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) >= maxValue) {
                maxValue = intList.get(i);
                lastIndex = i;
            }
        }
        System.out.println("Индекс последнего максимального элемента: " + lastIndex);
    }

// сортировка
    public void sortAscending() {
        intList.sort(Integer::compareTo);
        System.out.println("Список, отсортированный по возрастанию: " + intList);
    }

// убираем отрицательные числа
    public void removeNegatives() {
        intList.removeIf(n -> n < 0);
        System.out.println("Список после удаления отрицательных чисел: " + intList);
    }

// вызываем методы
    public static void main(String[] args) {
        IntegerOperations io = new IntegerOperations();
        if (!io.intList.isEmpty()) {
            io.findMaxValue();
            io.findLastMaxIndex();
            io.sortAscending();
            io.removeNegatives();
        }
    }
}
