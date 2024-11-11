import java.util.Scanner;

// Когда надо закрывать сканнер?

public class Bank6 {
    public static void main(String[] args) {
        // 50 100 1000
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сумму для выдачи банкоматом: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Введено некорректное значение");
            return;
        }
        int S = scanner.nextInt();

        if (S <= 0) {
            System.out.println("Сумма не может быть отрицательной, а с 0 выдавать нечего");
            return;
        }
        if (S % 50 != 0) {
           System.out.println("Такую сумму выдать нельзя");
           return;
        }

        int thousands = 0;
        int hundreds = 0;
        int fifties = 0;

        if (S >= 1000) {
            thousands = S / 1000;
            S = S % 1000;
        }
        if (S >= 100) {
            hundreds = S / 100;
            S = S % 100;
        }
        if (S >= 50) {
            fifties = S / 50;
            S = S % 50;
        }

        if (S > 0) {
           System.out.println("Такую сумму выдать нельзя");
        } else {
            System.out.println("Выдано");
            if (thousands > 0) { System.out.println("купюр по 1000: " + thousands);
            }
            if (hundreds > 0) { System.out.println("купюр по 100: " + hundreds);
            }
            if (fifties > 0) { System.out.println("купюр по 50: " + fifties);
            }
        }
        scanner.close();
    }
}
