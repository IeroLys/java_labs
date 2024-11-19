import java.time.LocalDate;

class Book {
    private String title;       // Название книги
    private String author;      // Автор книги
    private int dayOfReturn;    // День сдачи книги
    private int monthOfReturn;  // Месяц сдачи книги

    // Конструктор с параметрами
    public Book(String title, String author, int dayOfReturn, int monthOfReturn) {
        this.title = title;
        this.author = author;
        this.dayOfReturn = dayOfReturn;
        this.monthOfReturn = monthOfReturn;
    }

    // Конструктор копирования
    public Book(Book other) {
        this.title = other.title;
        this.author = other.author;
        this.dayOfReturn = other.dayOfReturn;
        this.monthOfReturn = other.monthOfReturn;
    }

    // Геттеры для полей
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getDayOfReturn() {
        return dayOfReturn;
    }

    public int getMonthOfReturn() {
        return monthOfReturn;
    }

    // Метод проверки, сдана ли книга вовремя
    public boolean isReturnedOnTime() {
        // Если книга должна быть сдана до 29 марта, то считается, что она сдана вовремя
        LocalDate dueDate = LocalDate.of(LocalDate.now().getYear(), 3, 29);
        LocalDate returnDate = LocalDate.of(LocalDate.now().getYear(), monthOfReturn, dayOfReturn);
        return !returnDate.isAfter(dueDate);
    }
}
