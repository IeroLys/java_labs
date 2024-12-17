import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Pupil> pupils = new ArrayList<>();
        List<SchoolStudent> schoolStudents = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        try {
           // создаём школьников и студентов
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
            ss3.addSubjectGrade("math", 4);
            ss3.addSubjectGrade("russian", 4);
            ss3.addSubjectGrade("history", 5);
            ss3.addSubjectGrade("english", 5);
            ss3.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.SCHOOL, 3));
            if (ss3.isEligibleForScholarship()) {
                pupils.add(ss3);
                schoolStudents.add(ss3);
            }

          
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

        // Задача 1: Сортируем по фамилиям степендиантов
// сортируем
        Collections.sort(pupils);
// выводы
        System.out.println("Eligible pupils sorted by surname:");
        System.out.println(String.format("%-20s %-20s %-10s %-5s", "Name", "Surname", "Gender", "Age"));
        for (Pupil pupil : pupils) {
            System.out.println(String.format("%-20s %-20s %-10s %-5d", pupil.getName(), pupil.getSurname(), pupil.getGender(), pupil.getAge()));
        }
        System.out.println();

        // Task 2: Найти лучшего студента и школьника
        Student bestStudent = null;
        SchoolStudent bestSchoolStudent = null;

        for (Pupil pupil : pupils) {
// если учащийся это студент
            if (pupil instanceof Student) {
                Student currentStudent = (Student) pupil;
                if (bestStudent == null || currentStudent.getAcademicPerformanceRating() > bestStudent.getAcademicPerformanceRating()) {
                    bestStudent = currentStudent;
                }
// если это школьник
            } else if (pupil instanceof SchoolStudent) {
                SchoolStudent currentSchoolStudent = (SchoolStudent) pupil;
                if (bestSchoolStudent == null || currentSchoolStudent.getAcademicPerformanceRating() > bestSchoolStudent.getAcademicPerformanceRating()) {
                    bestSchoolStudent = currentSchoolStudent;
                }
            }
        }

// выводы
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

        // Задача 3: сортируем по успеваемости и школе
        Comparator<SchoolStudent> comparator =
                Comparator.comparingDouble(SchoolStudent::getAcademicPerformanceRating).reversed()
                        .thenComparingInt(SchoolStudent::getSchoolNumber);
// сортируем по компаратору
        schoolStudents.sort(comparator);

// выводы
        System.out.println("School students sorted by performance and school number:");
        System.out.println(String.format("%-20s %-20s %-10s %-5s %-10s %-15s", "Name", "Surname", "Gender", "Age", "School Number", "Performance"));
        for (SchoolStudent ss : schoolStudents) {
            System.out.println(String.format("%-20s %-20s %-10s %-5d %-10d %-15.1f", ss.getName(), ss.getSurname(), ss.getGender(), ss.getAge(), ss.getSchoolNumber(), ss.getAcademicPerformanceRating()));
        }
        System.out.println();

        // Задача 4: сортируем студентов по успеваемости
        students.sort(Comparator.comparingDouble(Student::getAcademicPerformanceRating).reversed());

        System.out.println("Students sorted by performance:");
        System.out.println(String.format("%-20s %-20s %-10s %-5s %-15s", "Name", "Surname", "Gender", "Age", "Performance"));
        for (Student st : students) {
            System.out.println(String.format("%-20s %-20s %-10s %-5d %-15.1f", st.getName(), st.getSurname(), st.getGender(), st.getAge(), st.getAcademicPerformanceRating()));
        }
        System.out.println();
    }
}