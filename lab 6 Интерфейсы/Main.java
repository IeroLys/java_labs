import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pupil> eligiblePupils = new ArrayList<>();

        // Create SchoolStudent objects
        try {
            SchoolStudent student1 = new SchoolStudent("Alice", "Smith", "female", 14, 1);
            student1.addSubjectGrade("math", 5);
            student1.addSubjectGrade("russian", 5);
            student1.addSubjectGrade("history", 5);
            student1.addSubjectGrade("english", 5);
            student1.addSubjectGrade("science", 4);
            student1.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.SCHOOL, 1));
            if (student1.isEligibleForScholarship()) {
                eligiblePupils.add(student1);
            }

            SchoolStudent student2 = new SchoolStudent("Bob", "Johnson", "male", 15, 2);
            student2.addSubjectGrade("math", 5);
            student2.addSubjectGrade("russian", 5);
            student2.addSubjectGrade("history", 5);
            student2.addSubjectGrade("english", 5);
            student2.addSubjectGrade("science", 3);
            student2.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.CITY, 2));
            if (student2.isEligibleForScholarship()) {
                eligiblePupils.add(student2);
            }

            SchoolStudent student3 = new SchoolStudent("Eve", "Williams", "female", 16, 1);
            student3.addSubjectGrade("math", 5);
            student3.addSubjectGrade("russian", 5);
            student3.addSubjectGrade("history", 5);
            student3.addSubjectGrade("english", 5);
            student3.addSubjectGrade("science", 4);
            student3.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.REGIONAL, 1));
            if (student3.isEligibleForScholarship()) {
                eligiblePupils.add(student3);
            }
        } catch (InvalidDataException e) {
            System.err.println("Invalid data while creating SchoolStudent: " + e.getMessage());
        }

        // Create Student objects
        try {
            Student student4 = new Student("Charlie", "Brown", "male", 20);
            student4.addExamGrade(5);
            student4.addExamGrade(5);
            student4.addExamGrade(4);
            student4.addCourseworkGrade(5);
            if (student4.isEligibleForScholarship()) {
                eligiblePupils.add(student4);
            }

            Student student5 = new Student("Diana", "Green", "female", 22);
            student5.addExamGrade(5);
            student5.addExamGrade(4);
            student5.addExamGrade(4);
            // No coursework grades
            if (student5.isEligibleForScholarship()) {
                eligiblePupils.add(student5);
            }

            Student student6 = new Student("Frank", "White", "male", 21);
            student6.addExamGrade(5);
            student6.addExamGrade(5);
            student6.addExamGrade(5);
            student6.addCourseworkGrade(5);
            student6.addCourseworkGrade(5);
            if (student6.isEligibleForScholarship()) {
                eligiblePupils.add(student6);
            }
        } catch (InvalidDataException e) {
            System.err.println("Invalid data while creating Student: " + e.getMessage());
        }

        // Task 1: Print eligible pupils sorted by surname
        Collections.sort(eligiblePupils);
        System.out.println("Eligible pupils sorted by surname:");
        for (Pupil pupil : eligiblePupils) {
            System.out.println(pupil.toString());
        }
        System.out.println();

        // Task 2: Determine the best-performing student and school student
        double maxStudentRating = Double.MIN_VALUE;
        Student bestStudent = null;
        double maxSchoolStudentRating = Double.MIN_VALUE;
        SchoolStudent bestSchoolStudent = null;

        for (Pupil pupil : eligiblePupils) {
            if (pupil instanceof Student) {
                Student s = (Student) pupil;
                if (s.getAcademicPerformanceRating() > maxStudentRating) {
                    maxStudentRating = s.getAcademicPerformanceRating();
                    bestStudent = s;
                }
            } else if (pupil instanceof SchoolStudent) {
                SchoolStudent ss = (SchoolStudent) pupil;
                if (ss.getAcademicPerformanceRating() > maxSchoolStudentRating) {
                    maxSchoolStudentRating = ss.getAcademicPerformanceRating();
                    bestSchoolStudent = ss;
                }
            }
        }

        System.out.println("Best-performing Student: " + (bestStudent != null ? bestStudent.toString() : "None"));
        System.out.println("Best-performing SchoolStudent: " + (bestSchoolStudent != null ? bestSchoolStudent.toString() : "None"));
        System.out.println();

        // Task 3: Print list of school students sorted by performance rating and then by school number
        List<SchoolStudent> schoolStudents = new ArrayList<>();
        for (Pupil pupil : eligiblePupils) {
            if (pupil instanceof SchoolStudent) {
                schoolStudents.add((SchoolStudent) pupil);
            }
        }

        Comparator<SchoolStudent> schoolStudentComparator = new Comparator<SchoolStudent>() {
            @Override
            public int compare(SchoolStudent s1, SchoolStudent s2) {
                int ratingComparison = Double.compare(s2.getAcademicPerformanceRating(), s1.getAcademicPerformanceRating());
                if (ratingComparison != 0) {
                    return ratingComparison;
                }
                return Integer.compare(s1.getSchoolNumber(), s2.getSchoolNumber());
            }
        };

        Collections.sort(schoolStudents, schoolStudentComparator);
        System.out.println("School students sorted by performance rating and school number:");
        for (SchoolStudent student : schoolStudents) {
            System.out.println(student.toString());
        }
        System.out.println();

        // Task 4: Print list of students sorted by performance rating
        List<Student> students = new ArrayList<>();
        for (Pupil pupil : eligiblePupils) {
            if (pupil instanceof Student) {
                students.add((Student) pupil);
            }
        }

        Comparator<Student> studentComparator = new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.getAcademicPerformanceRating(), s1.getAcademicPerformanceRating());
            }
        };

        Collections.sort(students, studentComparator);
        System.out.println("Students sorted by performance rating:");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}