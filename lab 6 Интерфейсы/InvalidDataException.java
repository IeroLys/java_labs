// пользовательское исключение
public class InvalidDataException extends Exception {
    public InvalidDataException(String message) {
//вызываем конструктор родительского класса, передаём ошибку
        super(message);
    }
}