import java.io.*; // работа с файлами
import java.util.*;

public class Main {
    public static void main(String[] args) {
// читаем файл, создаём список курсов
        List<Course> courses = readCoursesFromFile("C:/Users/Юля/IdeaProjects/indiv2/src/data_course.txt");
        if (courses == null) {
            System.err.println("Не удалось прочитать курсы из файла.");
            return;
        }

        // Вывод бесплатных курсов, отсортированных по длительности
        List<Course> freeCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.isFree()) {
                continue;
            }
            freeCourses.add(course);
        }

        // Сортировка бесплатных курсов по длительности
        Collections.sort(freeCourses, Comparator.comparingInt(Course::getDurationMonths));

        System.out.println("Список бесплатных курсов, отсортированных по длительности:");
        System.out.println(String.format("%-50s %-20s", "Название", "Длительность (месяцы)"));
        for (Course course : freeCourses) {
            System.out.println(String.format("%-50s %-20d", course.getName(), course.getDurationMonths()));
        }

        // Получение диапазона цен от пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите нижнюю границу цены:");
        double lowerBound = 0;
        if (scanner.hasNextDouble()) {
            lowerBound = scanner.nextDouble();
        } else {
            System.err.println("Неверный ввод нижней границы.");
            return;
        }

        System.out.println("Введите верхнюю границу цены:");
        double upperBound = 0;
        if (scanner.hasNextDouble()) {
            upperBound = scanner.nextDouble();
        } else {
            System.err.println("Неверный ввод верхней границы.");
            return;
        }

        // Фильтрация платных курсов в заданном диапазоне цен
        List<Course> paidCoursesInRange = new ArrayList<>();
        for (Course course : courses) {
            if (!course.isFree()) {
                continue;
            }
            if (course.getCost() >= lowerBound && course.getCost() <= upperBound) {
                paidCoursesInRange.add(course);
            }
        }

        // Проверка на наличие платных курсов в заданном диапазоне
        if (paidCoursesInRange.isEmpty()) {
            System.out.println("В заданном диапазоне не найдено платных курсов.");
        } else {
            // Сортировка платных курсов по названию
            Collections.sort(paidCoursesInRange, Comparator.comparing(Course::getName));

            // Вывод платных курсов в файл
            writePaidCoursesToFile(paidCoursesInRange, "paid_courses.txt");
        }
    }

    private static List<Course> readCoursesFromFile(String filename) {
// храним курсы
        List<Course> courses = new ArrayList<>();
// читаеи построчно
/*
FileInputStream: Открывает файл для чтения.

InputStreamReader: Преобразует байтовый поток в символьный с указанием кодировки (UTF-8).
*/
        List<String> lines = new ArrayList<>();
// читаем построчно
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
            String line;
// пока не конец файла
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line.trim());
                }
            }
// проверка данных
            for (int i = 0; i < lines.size(); i += 10) {
                if (i + 9 >= lines.size()) {
                    System.err.println("Неполные данные для курса в строке " + i);
                    continue;
                }
// извлекаем данные
                String id = lines.get(i);
                String name = lines.get(i + 1);
                String url = lines.get(i + 2);
                String freeStr = lines.get(i + 3);
                String costStr = lines.get(i + 4);
                String studentsStr = lines.get(i + 5);
                String reviewsStr = lines.get(i + 6);
                String lecturesStr = lines.get(i + 7);
                String difficulty = lines.get(i + 8);
                String durationStr = lines.get(i + 9);

// преобразовываем строки
                boolean isFree = Boolean.parseBoolean(freeStr);
                double cost = 0.0;
                try {
                    cost = Double.parseDouble(costStr);
                } catch (NumberFormatException e) {
                    System.err.println("Неверный формат стоимости для курса " + name + ": " + costStr);
                    continue;
                }
                int numberOfStudents = Integer.parseInt(studentsStr);
                int numberOfReviews = Integer.parseInt(reviewsStr);
                int numberOfLectures = Integer.parseInt(lecturesStr);
                int durationMonths = Integer.parseInt(durationStr);

                Course course = new Course(id, name, url, isFree, cost, numberOfStudents,
                        numberOfReviews, numberOfLectures, difficulty, durationMonths);
                //System.out.println("Добавлен курс: " + course.getName() + " - Бесплатный: " + course.isFree() + " - Стоимость: " + course.getCost());
                courses.add(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return courses;
    }

    private static void writePaidCoursesToFile(List<Course> paidCourses, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            // Запись заголовков таблицы
            bw.write(String.format("%-50s %-50s %-20s %-10s", "Название", "URL", "Количество лекций", "Стоимость"));
            bw.newLine();
            // Запись данных курсов
            for (Course course : paidCourses) {
                bw.write(String.format("%-50s %-50s %-20d %-10.2f", course.getName(), course.getUrl(),
                        course.getNumberOfLectures(), course.getCost()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
