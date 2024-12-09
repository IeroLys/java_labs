import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Task 1: Girls who got first places in Olympiads
        List<Schoolkid> schoolkids = new ArrayList<>();

        // Sample data for Schoolkids
        Schoolkid kid1 = new Schoolkid("Alice", "female", 14);
        Map<String, Integer> grades1 = new HashMap<>();
        grades1.put("math", 5);
        grades1.put("russian", 5);
        grades1.put("history", 5);
        grades1.put("english", 5);
        grades1.put("science", 4);
        kid1.setSubjectGrades(grades1);
        List<OlympiadParticipation> olympiads1 = new ArrayList<>();
        olympiads1.add(new OlympiadParticipation(OlympiadLevel.SCHOOL, 1));
        kid1.setOlympiadParticipations(olympiads1);
        schoolkids.add(kid1);

        // Add more Schoolkids with different data...

        // Filter and print girls who got first places
        for (Schoolkid kid : schoolkids) {
            if ("female".equals(kid.getGender())) {
                for (OlympiadParticipation participation : kid.getOlympiadParticipations()) {
                    if (participation.getPlace() == 1) {
                        System.out.println("Girl eligible: " + kid.getName());
                        break;
                    }
                }
            }
        }

        // Task 2: Students with coursework grades
        List<HigherEducationStudent> students = new ArrayList<>();

        // Sample data for Students
        HigherEducationStudent student1 = new HigherEducationStudent("Bob", "male", 20);
        List<Integer> exams1 = new ArrayList<>();
        exams1.add(5);
        exams1.add(5);
        exams1.add(4);
        student1.setExamGrades(exams1);
        List<Integer> coursework1 = new ArrayList<>();
        coursework1.add(5);
        coursework1.add(5);
        student1.setCourseworkGrades(coursework1);
        students.add(student1);

        // Add more Students with different data...

        // Filter and print Students with coursework grades
        for (HigherEducationStudent student : students) {
            if (!student.getCourseworkGrades().isEmpty()) {
                System.out.println("Student with coursework: " + student.getName());
            }
        }

        // Task 3: General list of eligible students for scholarship
        List<Student> allStudents = new ArrayList<>();
        allStudents.addAll(schoolkids);
        allStudents.addAll(students);

        // Filter and print eligible students
        for (Student student : allStudents) {
            if (student.isEligibleForScholarship()) {
                System.out.println("Eligible for scholarship: " + student.getName());
            }
        }
    }
}