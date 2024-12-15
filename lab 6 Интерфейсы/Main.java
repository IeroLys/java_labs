import java.util.*;

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
            ss1.addSubjectGrade("history", 5);
            ss1.addSubjectGrade("english", 5);
            ss1.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.SCHOOL, 1));
            if (ss1.isEligibleForScholarship()) {
                pupils.add(ss1);
                schoolStudents.add(ss1);
            }

            SchoolStudent ss2 = new SchoolStudent("Bob", "Johnson", "male", 15, 2);
            ss2.addSubjectGrade("math", 5);
            ss2.addSubjectGrade("russian", 5);
            ss2.addSubjectGrade("history", 5);
            ss2.addSubjectGrade("english", 5);
            ss2.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.CITY, 2));
            if (ss2.isEligibleForScholarship()) {
                pupils.add(ss2);
                schoolStudents.add(ss2);
            }

            SchoolStudent ss3 = new SchoolStudent("Mika", "Ssmith", "female", 14, 1);
            ss1.addSubjectGrade("math", 4);
            ss1.addSubjectGrade("russian", 4);
            ss1.addSubjectGrade("history", 5);
            ss1.addSubjectGrade("english", 5);
            ss1.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.SCHOOL, 3));
            if (ss3.isEligibleForScholarship()) {
                pupils.add(ss3);
                schoolStudents.add(ss3);
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
        System.out.println(String.format("%-20s %-20s %-10s %-5s", "Name", "Surname", "Gender", "Age"));
        for (Pupil pupil : pupils) {
            System.out.println(String.format("%-20s %-20s %-10s %-5d", pupil.getName(), pupil.getSurname(), pupil.getGender(), pupil.getAge()));
        }
        System.out.println();

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
        System.out.println();

        // Task 3: Sort school students by academic performance and school number
        // First, sort by academic performance in descending order
        Collections.sort(schoolStudents, Comparator.comparingDouble(SchoolStudent::getAcademicPerformanceRating).reversed());

        // Then, sort by school number in ascending order
        Collections.sort(schoolStudents, Comparator.comparingInt(SchoolStudent::getSchoolNumber));

        System.out.println("School students sorted by performance and school number:");
        System.out.println(String.format("%-20s %-20s %-10s %-5s %-10s %-15s", "Name", "Surname", "Gender", "Age", "School Number", "Performance"));
        for (SchoolStudent ss : schoolStudents) {
            System.out.println(String.format("%-20s %-20s %-10s %-5d %-10d %-15.1f", ss.getName(), ss.getSurname(), ss.getGender(), ss.getAge(), ss.getSchoolNumber(), ss.getAcademicPerformanceRating()));
        }
        System.out.println();

        // Task 4: Sort students by academic performance
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getAcademicPerformanceRating(), s1.getAcademicPerformanceRating());
            }
        });

        System.out.println("Students sorted by performance:");
        System.out.println(String.format("%-20s %-20s %-10s %-5s %-15s", "Name", "Surname", "Gender", "Age", "Performance"));
        for (Student st : students) {
            System.out.println(String.format("%-20s %-20s %-10s %-5d %-15.1f", st.getName(), st.getSurname(), st.getGender(), st.getAge(), st.getAcademicPerformanceRating()));
        }
        System.out.println();
    }
}