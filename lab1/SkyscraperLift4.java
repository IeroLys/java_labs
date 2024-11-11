
import java.util.Scanner;


public class SkyscraperLift4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество этажей в доме (N): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Введено некорректное значение");
            return;
        }
        int N = scanner.nextInt();
        if (N <= 0) {
            System.out.println("Этаж не может быть 0 или отрицательным числом");
            return;
        }


        System.out.print("Введите номер квартиры (M): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Введено некорректное значение");
            return;
        }
        int M = scanner.nextInt();
        if (M <= 0) {
            System.out.println("Квартира не может быть 0 или отрицательным числом");
            return;
        }

        // Количество квартир на этаже
        int apartmentsPerFloor = 3;

        // Номер этажа, на котором находится квартира
        int targetFloor = (M + apartmentsPerFloor - 1) / apartmentsPerFloor;

        if (targetFloor % 2 == 0) {
            targetFloor--;  // Если этаж чётный, лифт поедет на ближайший нечётный
        }

        // Проверка на случай, если нужный этаж превышает количество этажей
        if (targetFloor > N) {
            System.out.println("Ошибка: такого этажа нет в доме");
        } else {
            System.out.println("Лифт остановится на этаже: " + targetFloor);
        }
        scanner.close();
    }
}
