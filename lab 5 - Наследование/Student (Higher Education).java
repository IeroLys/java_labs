import java.util.ArrayList;
import java.util.List;

public class HigherEducationStudent extends Student {
    private List<Integer> examGrades;
    private List<Integer> courseworkGrades;

    public HigherEducationStudent(String name, String gender, int age) {
        super(name, gender, age);
        this.examGrades = new ArrayList<>();
        this.courseworkGrades = new ArrayList<>();
    }

    // Getters and setters for examGrades and courseworkGrades

    public List<Integer> getExamGrades() {
        return examGrades;
    }

    public void setExamGrades(List<Integer> examGrades) {
        this.examGrades = examGrades;
    }

    public List<Integer> getCourseworkGrades() {
        return courseworkGrades;
    }

    public void setCourseworkGrades(List<Integer> courseworkGrades) {
        this.courseworkGrades = courseworkGrades;
    }

    @Override
    public boolean isEligibleForScholarship() {
        // Check average exam score
        if (examGrades.isEmpty()) {
            return false;
        }
        double averageExamScore = examGrades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        if (averageExamScore < 4.75) {
            return false;
        }
        // Check coursework grades
        if (courseworkGrades.isEmpty()) {
            return false;
        }
        for (Integer grade : courseworkGrades) {
            if (grade != 5) {
                return false;
            }
        }
        return true;
    }
}