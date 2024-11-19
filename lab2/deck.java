/*
 * Напишите программу имитирующую раздачу карт для игры в покер для N 
(задает пользователь) игроков. Колода состоит из 52 карт четырех мастей, 
каждая масть начинается с двойки и заканчивается тузом. Каждый игрок 
должен получить пять случайных карт. Если игроков слишком много, 
выдать соответствующее сообщение.
8
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class deck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество игроков: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Введено некорректное значение");
            return;
        }
        int numberOfPlayers = scanner.nextInt();

        // Проверка на допустимое количество игроков
        if (numberOfPlayers <= 0 || numberOfPlayers > 10) {
            System.out.println("Ошибка: количество игроков должно быть от 1 до 10.");
            return;
        }

        // Создание колоды карт
        List<String> deck = createDeck();

        // Перемешивание колоды
        Collections.shuffle(deck);

        // Раздача карт игрокам
        for (int i = 0; i < numberOfPlayers; i++) {
            List<String> hand = dealCards(deck);
            System.out.println("Игрок " + (i + 1) + ": " + hand);
        }
    }

    // Метод для создания колоды
    private static List<String> createDeck() {
        List<String> deck = new ArrayList<>();
        String[] suits = {"Черви", "Бубны", "Крести", "Пики"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " " + suit);
            }
        }

        return deck;
    }

    // Метод для выдачи 5 карт
    private static List<String> dealCards(List<String> deck) {
        List<String> hand = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            hand.add(deck.remove(deck.size() - 1)); // Берем последнюю карту из колоды
        }
        return hand;
    }
}