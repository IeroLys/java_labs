import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        List<Pupil> pupils = new ArrayList<>();

        // Create and add SchoolStudent and Student objects
        // ...

        // Task 1: Sort and print pupils by surname
        Collections.sort(pupils);
        System.out.println("Eligible pupils sorted by surname:");
        for (Pupil pupil : pupils) {
            System.out.println(pupil.toString());
        }

        // Task 2: Find the best-performing student and school student
        // Implement comparison logic
        // ...

        // Task 3: Sort school students by academic performance and school number
        // Implement custom comparator
        // ...

        // Task 4: Sort students by academic performance
        // Implement custom comparator
        // ...
    }
}