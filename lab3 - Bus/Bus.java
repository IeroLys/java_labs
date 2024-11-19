public class Bus {
    private int totalSeats; // кол-во мест
    private int occupiedSeats; // занятые места
    private double seatPrice; // цена за место

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

    // кол-во свободных мест
    public int getFreeSeats() {
        return totalSeats - occupiedSeats;
    }

    //  метод рассчитывающий общую стоимость занятых мест.
    public double calculateTotalRevenue() {
        return occupiedSeats * seatPrice;
    }

    // пуст автобус или заполнен
    public boolean isFull() {
        return occupiedSeats == totalSeats;
    }
}
