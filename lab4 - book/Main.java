public class Main {
    public static void main(String[] args) {
        // Создаем книги
        Book book1 = new Book("Java 8. Полное руководство", "Г. Шилдт", 1, 4); // Петров
        Book book2 = new Book("Крейцерова соната", "Л. Толстой", 25, 3);       // Васечкин

        // Создаем читателей
        Reader reader1 = new Reader("Зайкина", book1);
        Reader reader2 = new Reader("Лесков", book2);

        // Проверяем, кто сдал книги вовремя
        reader1.checkIfReturnedOnTime();
        reader2.checkIfReturnedOnTime();
    }
}
