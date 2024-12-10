import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Задача 1: Девушки, занявшие первые места на олимпиадах
        List<SchoolStudent> schoolStudents = new ArrayList<>();

        // SchoolStudent 1
        SchoolStudent kid1 = new SchoolStudent("Alice", "female", 14);
        kid1.addSubjectGrade("math", 5);
        kid1.addSubjectGrade("russian", 5);
        kid1.addSubjectGrade("history", 5);
        kid1.addSubjectGrade("english", 5);
        kid1.addSubjectGrade("science", 4);
        kid1.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.SCHOOL, 1));
        schoolStudents.add(kid1);

        // SchoolStudent 2
        SchoolStudent kid2 = new SchoolStudent("Bob", "male", 15);
        kid2.addSubjectGrade("math", 5);
        kid2.addSubjectGrade("russian", 5);
        kid2.addSubjectGrade("history", 5);
        kid2.addSubjectGrade("english", 5);
        kid2.addSubjectGrade("science", 3);
        kid2.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.CITY, 2));
        schoolStudents.add(kid2);

        // SchoolStudent 3
        SchoolStudent kid3 = new SchoolStudent("Eve", "female", 16);
        kid3.addSubjectGrade("math", 5);
        kid3.addSubjectGrade("russian", 5);
        kid3.addSubjectGrade("history", 5);
        kid3.addSubjectGrade("english", 5);
        kid3.addSubjectGrade("science", 4);
        kid3.addOlympiadParticipation(new OlympiadParticipation(OlympiadLevel.REGIONAL, 1));
        schoolStudents.add(kid3);

        // Выводим всех школьников
        System.out.println("Все школьники:");
        for (SchoolStudent student : schoolStudents) {
            System.out.println(student.toString());
        }
        System.out.println("\n");

        // Фильтруем девочек с первым местом
        for (SchoolStudent kid : schoolStudents) {
            if ("female".equals(kid.getGender())) {
                for (OlympiadParticipation participation : kid.getOlympiadParticipations()) {
                    if (participation.getPlace() == 1) {
                        System.out.println("Девочки с первом местом: " + kid.getName());
                        break;
                    }
                }
            }
        }

        // Задача 2: Студенты с курсовыми оценками
        List<Student> students = new ArrayList<>();

        // Student 1
        Student student1 = new Student("Charlie", "male", 20);
        student1.addExamGrade(5);
        student1.addExamGrade(5);
        student1.addExamGrade(4);
        student1.addCourseworkGrade(5);
        students.add(student1);

        // Student 2
        Student student2 = new Student("Diana", "female", 22);
        student2.addExamGrade(5);
        student2.addExamGrade(4);
        student2.addExamGrade(4);
        // без курсовых будет
        students.add(student2);

        // Student 3
        Student student3 = new Student("Frank", "male", 21);
        student3.addExamGrade(5);
        student3.addExamGrade(5);
        student3.addExamGrade(5);
        student3.addCourseworkGrade(5);
        student3.addCourseworkGrade(5);
        students.add(student3);

        // выводим всех студентов
        System.out.println("\nВсе студенты:");
        for (Student student : students) {
            System.out.println(student.toString());
        }
        System.out.println("\n");

        // фильтруем и печатаем студентов с курсовыми оценками
        for (Student student : students) {
            if (!student.getCourseworkGrades().isEmpty()) {
                System.out.println("Студенты с курсовыми оценками: " + student.getName());
            }
        }

        // Задача 3: общий список студентов и школьников, имеющих право на получение стипендии
        List<Pupil> pupils = new ArrayList<>();
        pupils.addAll(schoolStudents);
        pupils.addAll(students);

        // фильтрация и печать подходящих студентов
        for (Pupil pupil : pupils) {
            if (pupil.isEligibleForScholarship()) {
                System.out.println("Право на стипендию: " + pupil.getName());
            }
        }
    }
}
