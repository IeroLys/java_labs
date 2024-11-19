Вот реализация задачи на языке Java:

```java
class Bus {
    private int totalSeats;
    private int occupiedSeats;
    private double seatPrice;

    // Конструктор по умолчанию
    public Bus() {
        this.totalSeats = 0;
        this.occupiedSeats = 0;
        this.seatPrice = 0;
    }

    // Конструктор с параметрами
    public Bus(int totalSeats, double seatPrice) {
        this.totalSeats = totalSeats;
        this.occupiedSeats = 0; // По умолчанию автобус пустой
        this.seatPrice = seatPrice;
    }

    // Метод копирования
    public Bus(Bus other) {
        this.totalSeats = other.totalSeats;
        this.occupiedSeats = other.occupiedSeats;
        this.seatPrice = other.seatPrice;
    }

    // Методы изменения и возврата значений полей
    public void setOccupiedSeats(int occupiedSeats) {
        if (occupiedSeats <= totalSeats) {
            this.occupiedSeats = occupiedSeats;
        } else {
            System.out.println("Ошибка: Количество занятых мест превышает общее число мест.");
        }
    }

    public int getOccupiedSeats() {
        return occupiedSeats;
    }

    public int getFreeSeats() {
        return totalSeats - occupiedSeats;
    }

    public double calculateTotalRevenue() {
        return occupiedSeats * seatPrice;
    }

    public boolean isFull() {
        return occupiedSeats == totalSeats;
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем два объекта класса Bus
        Bus bus1 = new Bus(54, 400);
        Bus bus2 = new Bus(45, 500);

        // Группы туристов
        int group1 = 25;
        int group2 = 30;

        // Распределение групп по автобусам
        if (group1 + group2 <= bus1.getFreeSeats()) {
            bus1.setOccupiedSeats(group1 + group2);
        } else {
            bus1.setOccupiedSeats(group1);
            bus2.setOccupiedSeats(group2);
        }

        // Подсчет рентабельности
        double bus1Revenue = bus1.calculateTotalRevenue();
        double bus2Revenue = bus2.calculateTotalRevenue();

        System.out.println("Автобус 1: Доход = " + bus1Revenue);
        System.out.println("Автобус 2: Доход = " + bus2Revenue);

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
```

Этот код соответствует требованиям задачи. Вы можете дополнить его дополнительными методами и алгоритмами, указанными в дополнительном задании.