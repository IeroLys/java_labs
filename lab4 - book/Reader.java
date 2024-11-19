class Reader {
    private String name;  // Имя читателя
    private Book book;    // Книга, взятая читателем

    // Конструктор с параметрами
    public Reader(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    // Метод проверки, сдал ли читатель книгу вовремя
    public void checkIfReturnedOnTime() {
        if (book.isReturnedOnTime()) {
            System.out.println(name + " сдал книгу \"" + book.getTitle() + "\" вовремя.");
        } else {
            System.out.println(name + " не сдал книгу \"" + book.getTitle() + "\" вовремя.");
        }
    }
}