import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Pupil> allPupils = new ArrayList<>();
        List<SchoolStudent> allSchoolStudents = new ArrayList<>();
        List<Student> allStudents = new ArrayList<>();
        List<Pupil> scholarshipEligiblePupils = new ArrayList<>();

        try {
            // Create and add SchoolStudent instances
            SchoolStudent ss1 = new SchoolStudent("Alice", "Smith", "female", 14, 1);
            ss1.addSubjectGrade("math", 5);
            ss1.addSubjectGrade("russian", 5);
            ss1.addSubjectGrade("history", 5);
            ss1.addSubjectGrade("english", 5);
            ss1.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.SCHOOL, 1));
            allPupils.add(ss1);
            allSchoolStudents.add(ss1);

            SchoolStudent ss2 = new SchoolStudent("Bob", "Johnson", "male", 15, 2);
            ss2.addSubjectGrade("math", 5);
            ss2.addSubjectGrade("russian", 5);
            ss2.addSubjectGrade("history", 5);
            ss2.addSubjectGrade("english", 5);
            ss2.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.CITY, 2));
            allPupils.add(ss2);
            allSchoolStudents.add(ss2);

            SchoolStudent ss3 = new SchoolStudent("Mika", "Ssmith", "female", 14, 1);
            ss3.addSubjectGrade("math", 4);
            ss3.addSubjectGrade("russian", 4);
            ss3.addSubjectGrade("history", 5);
            ss3.addSubjectGrade("english", 5);
            ss3.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.SCHOOL, 3));
            allPupils.add(ss3);
            allSchoolStudents.add(ss3);

            SchoolStudent ss4 = new SchoolStudent("Eve", "Williams", "female", 14, 3);
            ss4.addSubjectGrade("math", 4);
            ss4.addSubjectGrade("russian", 4);
            ss4.addSubjectGrade("history", 5);
            ss4.addSubjectGrade("english", 5);
            ss4.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.SCHOOL, 2));
            allPupils.add(ss4);
            allSchoolStudents.add(ss4);

            SchoolStudent ss5 = new SchoolStudent("Emma", "Williams", "female", 14, 2);
            ss5.addSubjectGrade("math", 3);
            ss5.addSubjectGrade("russian", 4);
            ss5.addSubjectGrade("history", 5);
            ss5.addSubjectGrade("english", 4);
            ss5.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.SCHOOL, 5));
            allPupils.add(ss5);
            allSchoolStudents.add(ss5);

            // Create and add Student instances
            Student st1 = new Student("Charlie", "Brown", "male", 20);
            st1.addExamGrade(5);
            st1.addExamGrade(5);
            st1.addCourseworkGrade(5);
            allPupils.add(st1);
            allStudents.add(st1);

            Student st2 = new Student("Diana", "Green", "female", 22);
            st2.addExamGrade(5);
            st2.addExamGrade(5);
            st2.addCourseworkGrade(5);
            allPupils.add(st2);
            allStudents.add(st2);

            Student st3 = new Student("Ella", "Moore", "female", 19);
            st3.addExamGrade(4);
            st3.addExamGrade(5);
            st3.addCourseworkGrade(4);
            allPupils.add(st3);
            allStudents.add(st3);

            Student st4 = new Student("Sam", "Taylor", "male", 21);
            st4.addExamGrade(3);
            st4.addExamGrade(4);
            st4.addCourseworkGrade(5);
            allPupils.add(st4);
            allStudents.add(st4);

            // Determine scholarship eligibility
            for (Pupil pupil : allPupils) {
                if (pupil.isEligibleForScholarship()) {
                    scholarshipEligiblePupils.add(pupil);
                }
            }

        } catch (InvalidDataException e) {
            System.err.println("Invalid data encountered: " + e.getMessage());
        }

        // Task 1: Sort and print all pupils by surname
        Collections.sort(allPupils);
        System.out.println("Stependiants sorted by surname:");
        System.out.println(String.format("%-20s %-20s %-10s %-5s", "Name", "Surname", "Gender", "Age"));
        for (Pupil pupil : scholarshipEligiblePupils) {
            System.out.println(String.format("%-20s %-20s %-10s %-5d", pupil.getName(), pupil.getSurname(), pupil.getGender(), pupil.getAge()));
        }
        System.out.println();


        // Task 2: Find the best-performing student and school student
        Student bestStudent = null;
        SchoolStudent bestSchoolStudent = null;

        for (Pupil pupil : scholarshipEligiblePupils) {
            if (pupil instanceof Student) {
                Student currentStudent = (Student) pupil;
                if (bestStudent == null || currentStudent.getAcademicPerformanceRating() > bestStudent.getAcademicPerformanceRating()) {
                    bestStudent = currentStudent;
                }
            } else if (pupil instanceof SchoolStudent) {
                SchoolStudent currentSchoolStudent = (SchoolStudent) pupil;
                if (bestSchoolStudent == null || currentSchoolStudent.getAcademicPerformanceRating() > bestSchoolStudent.getAcademicPerformanceRating()) {
                    bestSchoolStudent = currentSchoolStudent;
                }
            }
        }

        System.out.println("Best-performing Student:");
        if (bestStudent != null) {
            System.out.println(String.format("%-20s %-20s %-10s %-5s %-20s %-20s", "Name", "Surname", "Gender", "Age", "Exam Grades", "Coursework Grades"));
            System.out.println(String.format("%-20s %-20s %-10s %-5d %-20s %-20s",
                    bestStudent.getName(), bestStudent.getSurname(), bestStudent.getGender(), bestStudent.getAge(),
                    ((Student) bestStudent).getExamGrades().toString(), ((Student) bestStudent).getCourseworkGrades().toString()));
        } else {
            System.out.println("None");
        }

        System.out.println("\nBest-performing SchoolStudent:");
        if (bestSchoolStudent != null) {
            System.out.println(String.format("%-20s %-20s %-10s %-5s %-15s %-20s %-20s", "Name", "Surname", "Gender", "Age", "School Number", "Subject Grades", "Olympiad Participations"));
            System.out.println(String.format("%-20s %-20s %-10s %-5d %-15d %-20s %-20s",
                    bestSchoolStudent.getName(), bestSchoolStudent.getSurname(), bestSchoolStudent.getGender(), bestSchoolStudent.getAge(),
                    ((SchoolStudent) bestSchoolStudent).getSchoolNumber(), ((SchoolStudent) bestSchoolStudent).getSubjectGrades().toString(),
                    ((SchoolStudent) bestSchoolStudent).getOlympiadParticipations().toString()));
        } else {
            System.out.println("None");
        }
        System.out.println();

        // Task 3: Sort allSchoolStudents by performance descending and then by school number ascending
        allSchoolStudents.sort(Comparator
                .comparingDouble(SchoolStudent::getAcademicPerformanceRating).reversed()
                .thenComparingInt(SchoolStudent::getSchoolNumber));

        System.out.println("School students sorted by performance and school number:");
        System.out.println(String.format("%-20s %-20s %-10s %-5s %-10s %-15s", "Name", "Surname", "Gender", "Age", "School Number", "Performance"));
        for (SchoolStudent ss : allSchoolStudents) {
            System.out.println(String.format("%-20s %-20s %-10s %-5d %-10d %-15.1f", ss.getName(), ss.getSurname(), ss.getGender(), ss.getAge(), ss.getSchoolNumber(), ss.getAcademicPerformanceRating()));
        }
        System.out.println();

        // Task 4: Sort students by academic performance
        allStudents.sort(Comparator.comparingDouble(Student::getAcademicPerformanceRating).reversed());
        System.out.println("Students sorted by performance:");
        System.out.println(String.format("%-20s %-20s %-10s %-5s %-15s", "Name", "Surname", "Gender", "Age", "Performance"));
        for (Student st : allStudents) {
            System.out.println(String.format("%-20s %-20s %-10s %-5d %-15.1f", st.getName(), st.getSurname(), st.getGender(), st.getAge(), st.getAcademicPerformanceRating()));
        }
    }
}