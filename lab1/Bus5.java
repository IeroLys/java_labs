
import java.util.Scanner;

public class Bus5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод меньшего и большего номера билета
        System.out.print("Введите меньший номер билета (N): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Введено некорректное значение");
            return;
        }
        int N = scanner.nextInt();
        System.out.print("Введите больший номер билета (M): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Введено некорректное значение");
            return;
        }
        int M = scanner.nextInt();

        // Проверка на корректность ввода
        if (N < 100000 || M > 999999 || N > M) {
            System.out.println("Номера билетов должны быть шестизначными и N не может быть больше M.");
            return;
        }

        // Цикл для перебора всех билетов в заданном диапазоне
        int count = 0;
        for (int i = N; i <= M; i++) {
            int first = i / 100000;
            int second = i / 10000 % 10;
            int third = i / 1000 % 10;
            int fourth = i % 1000 / 100;
            int fith = i % 100 / 10;
            int sixth = i % 10;

            int sumTickets1 = first + second + third;
            int sumTickets2 = fourth + fith + sixth;
            if (sumTickets1 == sumTickets2){
                System.out.println("Счастливый билет: " + i);
                count += 1;
            }
        }
        if (count == 0) {
            System.out.println("Счастливых билетов в этом диапазоне нет");
        } else {
            System.out.println("Количество счастливых билетов: " + count);
        }
        scanner.close();
    }
}

