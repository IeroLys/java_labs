
public class Main {
    public static void main(String[] args) {
        // Создаем два объекта класса Bus
        Bus bus1 = new Bus(54, 400);
        Bus bus2 = new Bus(45, 500);

        // Группы туристов
        int group1 = 25;
        int group2 = 30;

        // Распределение групп по автобусам
        bus1.setOccupiedSeats(group1);
        bus2.setOccupiedSeats(group2);

        // Подсчет рентабельности
        double bus1Revenue = bus1.calculateTotalRevenue();
        double bus2Revenue = bus2.calculateTotalRevenue();

        System.out.println("Автобус 1: Доход = " + bus1Revenue);
        System.out.println("Автобус 2: Доход = " + bus2Revenue); // метод в Bus потому что к нему относится

        if (bus1Revenue > 11000) {
            System.out.println("Поездка на автобусе 1 выгодна.");
        } else {
            System.out.println("Поездка на автобусе 1 невыгодна.");
        }

        if (bus2Revenue > 11000) {
            System.out.println("Поездка на автобусе 2 выгодна.");
        } else {
            System.out.println("Поездка на автобусе 2 невыгодна.");
        }
    }
}


/* ООп наследование
приват паблик протектид по умолчанию
this
конструктор
*/
