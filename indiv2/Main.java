import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        List<Course> courses = readCoursesFromFile("data_course.txt");
        if (courses == null) {
            System.err.println("Failed to read courses from file.");
            return;
        }

        // Output free courses sorted by duration
        List<Course> freeCourses = new ArrayList<>();
        for (Course course : courses) {
            if (!course.isFree()) {
                continue;
            }
            freeCourses.add(course);
        }

        // Sort free courses by duration
        Collections.sort(freeCourses, Comparator.comparingInt(Course::getDurationMonths));

        System.out.println("List of Free Courses sorted by Duration:");
        for (Course course : freeCourses) {
            System.out.println(course);
        }

        // Get price range from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the lower price bound:");
        double lowerBound = 0;
        if (scanner.hasNextDouble()) {
            lowerBound = scanner.nextDouble();
        } else {
            System.err.println("Invalid lower bound input.");
            return;
        }

        System.out.println("Enter the upper price bound:");
        double upperBound = 0;
        if (scanner.hasNextDouble()) {
            upperBound = scanner.nextDouble();
        } else {
            System.err.println("Invalid upper bound input.");
            return;
        }

        // Filter paid courses within price range
        List<Course> paidCoursesInRange = new ArrayList<>();
        for (Course course : courses) {
            if (course.isFree()) {
                continue;
            }
            if (course.getCost() >= lowerBound && course.getCost() <= upperBound) {
                paidCoursesInRange.add(course);
            }
        }

        // Sort paid courses by name
        Collections.sort(paidCoursesInRange, Comparator.comparing(Course::getName));

        // Output paid courses to file
        writePaidCoursesToFile(paidCoursesInRange, "paid_courses.txt");
    }

    private static List<Course> readCoursesFromFile(String filename) {
        List<Course> courses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Read 10 lines for each course
                String id = line;
                String name = br.readLine();
                String url = br.readLine();
                String freeStr = br.readLine();
                String costStr = br.readLine();
                String studentsStr = br.readLine();
                String reviewsStr = br.readLine();
                String lecturesStr = br.readLine();
                String difficulty = br.readLine();
                String durationStr = br.readLine();

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