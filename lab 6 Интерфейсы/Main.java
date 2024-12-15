import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pupil> pupils = new ArrayList<>();
        List<SchoolStudent> schoolStudents = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        try {
            // Create and add SchoolStudent instances
            SchoolStudent ss1 = new SchoolStudent("Alice", "Smith", "female", 14, 1);
            ss1.addSubjectGrade("math", 5);
            ss1.addSubjectGrade("russian", 5);
            ss1.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.SCHOOL, 1));
            if (ss1.isEligibleForScholarship()) {
                pupils.add(ss1);
                schoolStudents.add(ss1);
            }

            SchoolStudent ss2 = new SchoolStudent("Bob", "Johnson", "male", 15, 2);
            ss2.addSubjectGrade("math", 5);
            ss2.addSubjectGrade("russian", 5);
            ss2.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.CITY, 2));
            if (ss2.isEligibleForScholarship()) {
                pupils.add(ss2);
                schoolStudents.add(ss2);
            }

            // Create and add Student instances
            Student st1 = new Student("Charlie", "Brown", "male", 20);
            st1.addExamGrade(5);
            st1.addExamGrade(5);
            st1.addCourseworkGrade(5);
            if (st1.isEligibleForScholarship()) {
                pupils.add(st1);
                students.add(st1);
            }

            Student st2 = new Student("Diana", "Green", "female", 22);
            st2.addExamGrade(5);
            st2.addExamGrade(5);
            st2.addCourseworkGrade(5);
            if (st2.isEligibleForScholarship()) {
                pupils.add(st2);
                students.add(st2);
            }

        } catch (InvalidDataException e) {
            System.err.println("Invalid data encountered: " + e.getMessage());
        }

        // Task 1: Sort and print pupils by surname
        Collections.sort(pupils);
        System.out.println("Eligible pupils sorted by surname:");
        if (!pupils.isEmpty()) {
            for (Pupil pupil : pupils) {
                System.out.println(pupil.toString());
                System.out.println(); // Empty line for separation
            }
        } else {
            System.out.println("No eligible pupils found.");
        }

        // Task 2: Find the best-performing student and school student
        PerformanceComparable bestStudent = null;
        PerformanceComparable bestSchoolStudent = null;

        for (Pupil pupil : pupils) {
            if (pupil instanceof Student) {
                if (bestStudent == null || ((Student) pupil).getAcademicPerformanceRating() > bestStudent.getAcademicPerformanceRating()) {
                    bestStudent = (Student) pupil;
                }
            } else if (pupil instanceof SchoolStudent) {
                if (bestSchoolStudent == null || ((SchoolStudent) pupil).getAcademicPerformanceRating() > bestSchoolStudent.getAcademicPerformanceRating()) {
                    bestSchoolStudent = (SchoolStudent) pupil;
                }
            }
        }

        System.out.println("Best-performing Student:");
        if (bestStudent != null) {
            System.out.println(bestStudent.toString());
        } else {
            System.out.println("None");
        }

        System.out.println("\nBest-performing SchoolStudent:");
        if (bestSchoolStudent != null) {
            System.out.println(bestSchoolStudent.toString());
        } else {
            System.out.println("None");
        }

        // Task 3: Sort school students by academic performance and school number
        Collections.sort(schoolStudents, new Comparator<SchoolStudent>() {
            @Override
            public int compare(SchoolStudent s1, SchoolStudent s2) {
                int ratingCompare = Double.compare(s2.getAcademicPerformanceRating(), s1.getAcademicPerformanceRating());
                if (ratingCompare != 0) {
                    return ratingCompare;
                }
                return Integer.compare(s1.getSchoolNumber(), s2.getSchoolNumber());
            }
        });

        System.out.println("\nSchool students sorted by performance and school number:");
        if (!schoolStudents.isEmpty()) {
            for (SchoolStudent ss : schoolStudents) {
                System.out.println(ss.toString());
                System.out.println(); // Empty line for separation
            }
        } else {
            System.out.println("No school students found.");
        }

        // Task 4: Sort students by academic performance
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getAcademicPerformanceRating(), s1.getAcademicPerformanceRating());
            }
        });

        System.out.println("\nStudents sorted by performance:");
        if (!students.isEmpty()) {
            for (Student st : students) {
                System.out.println(st.toString());
                System.out.println(); // Empty line for separation
            }
        } else {
            System.out.println("No students found.");
        }
    }
}