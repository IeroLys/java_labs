import java.util.ArrayList;
import java.util.List;

// класс Студент по заданию

public class Student extends Pupil {
    private List<Integer> examGrades;
    private List<Integer> courseworkGrades;

    public Student(String name, String gender, int age) {
        super(name, gender, age);
        this.examGrades = new ArrayList<>();
        this.courseworkGrades = new ArrayList<>();
    }

    public void addExamGrade(int grade) {
        examGrades.add(grade);
    }

    public void addCourseworkGrade(int grade) {
        courseworkGrades.add(grade);
    }

    public List<Integer> getCourseworkGrades() {
        return courseworkGrades;
    }

    // ср.балл не ниже 4.75 и оценка 5 за курсовые
    @Override
    public boolean isEligibleForScholarship() {
        if (examGrades.isEmpty()) {
            return false;
        }
        double averageExamScore = examGrades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        if (averageExamScore < 4.75) {
            return false;
        }
        if (courseworkGrades.isEmpty()) {
            return false;
        }
        for (int grade : courseworkGrades) {
            if (grade != 5) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", age=" + getAge() +
                ", examGrades=" + examGrades +
                ", courseworkGrades=" + courseworkGrades +
                '}';
    }

}
