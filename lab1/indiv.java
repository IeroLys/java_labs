import java.util.InputMismatchException;
import java.util.Scanner;

public class indiv {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a1 = 0, a2 = 0, b1 = 0, b2 = 0;
        try {
            System.out.println("введите катет 1 первого треугольника: ");
            a1 = scanner.nextInt();
            System.out.println("введите катет 2 первого треугольника: ");
            a2 = scanner.nextInt();
            System.out.println("введите катет 1 второго треугольника: ");
            b1 = scanner.nextInt();
            System.out.println("введите катет 2 второго треугольника: ");
            b2 = scanner.nextInt();
        } catch (InputMismatchException er) {
            System.out.println("Некорректный ввод ");
            return;
        }

        // проверка существования треугольников
        if (!RightTriangle2.isTriangle(a1, a2)) {
            System.out.println("Первый треугольник не существует");
            return;
        }
        if (!RightTriangle2.isTriangle(b1, b2)) {
            System.out.println("Второй треугольник не существует");
            return;
        }

        // Создаём два треугольника
        RightTriangle2 triangle1 = new RightTriangle2(a1, a2);
        RightTriangle2 triangle2 = new RightTriangle2(b1, b2);


        // Вывод информации о треугольниках
        System.out.println("Информация о первом треугольнике:");
        triangle1.printInfo();

        System.out.println("\nИнформация о втором треугольнике:");
        triangle2.printInfo();

        boolean res = isEqual(a1, a2, b1, b2);
        // Проверка на равенство треугольников
        if (res) {
            System.out.println("\nТреугольники равны.");
        } else {
            System.out.println("\nТреугольники не равны.");
        }
    }

    // Равенство треугольников по 2 катетам
    public static boolean isEqual(int a1, int a2, int b1, int b2) {
        return (a1 == a2 && b1 == b2) || (a1 == b1 && a2 == b2);
    }

}
