// используем класс Scanner из пакета java.util
import java.util.Scanner;

public class Year1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных
        System.out.print("Введите год (N): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Введено некорректное значение");
            scanner.close();
            return;
        }
        int year = scanner.nextInt();

        if (year <= 0) {
            System.out.println("Год должен быть положительным числом больше нуля");
            return;
        }

        int index = (year - 1996) % 12;

        if (index == 0) {
            System.out.print("Крыса");
        } else if (index == 1){
            System.out.print("Бык");
        } else if (index == 2){
            System.out.print("Тигр");
        } else if (index == 3){
            System.out.print("Заяц");
        } else if (index == 4){
            System.out.print("Дракон");
        } else if (index == 5){
            System.out.print("Змея");
        } else if (index == 6){
            System.out.print("Лошадь");
        } else if (index == 7){
            System.out.print("Коза");
        } else if (index == 8){
            System.out.print("Обезьяна");
        } else if (index == 9){
            System.out.print("Петух");
        } else if (index == 10){
            System.out.print("Собака");
        } else{
            System.out.print("Свинья");
        }
        scanner.close();
    }
}
