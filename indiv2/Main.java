import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Course> courses = readCoursesFromFile("C:/Users/Юля/IdeaProjects/indiv2/src/data_course.txt");
        if (courses == null) {
            System.err.println("не получилось прочитать.");
            return;
        }

        // выводим бесплатные курсы отсортированные по длительности
        List<Course> freeCourses = new ArrayList<>();
        for (Course course : courses) {
            if (!course.isFree()) {
                continue;
            }
            freeCourses.add(course);
        }
        // сортировка
        Collections.sort(freeCourses, Comparator.comparingInt(Course::getDurationMonths));

        System.out.println("Список бесплатных курсов, отсортированных по длительности:");
        for (Course course : freeCourses) {
            System.out.println(course);
        }

        // Цена от пользователя
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

        // фильтруем платные курсы по заданному диапазону цен
        List<Course> paidCoursesInRange = new ArrayList<>();
        for (Course course : courses) {
            if (course.isFree()) {
                continue;
            }
            if (course.getCost() >= lowerBound && course.getCost() <= upperBound) {
                paidCoursesInRange.add(course);
            }
        }

        // Сортируем платные курсы по имени
        Collections.sort(paidCoursesInRange, Comparator.comparing(Course::getName));

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
        List<Course> courses = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line.trim());
                }
            }
            for (int i = 0; i < lines.size(); i += 10) {
                if (i + 9 >= lines.size()) {
                    System.err.println("Incomplete data for course at line " + i);
                    continue;
                }
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

                boolean isFree = Boolean.parseBoolean(freeStr);
                double cost = Double.parseDouble(costStr);
                int numberOfStudents = Integer.parseInt(studentsStr);
                int numberOfReviews = Integer.parseInt(reviewsStr);
                int numberOfLectures = Integer.parseInt(lecturesStr);
                int durationMonths = Integer.parseInt(durationStr);

                Course course = new Course(id, name, url, isFree, cost, numberOfStudents,
                        numberOfReviews, numberOfLectures, difficulty, durationMonths);
                courses.add(course);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
        return courses;
    }

    private static void writePaidCoursesToFile(List<Course> paidCourses, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            // Write table headers
            bw.write(String.format("%-50s %-50s %-20s %-10s", "Name", "URL", "Number of Lectures", "Cost"));
            bw.newLine();
            // Write courses data
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
