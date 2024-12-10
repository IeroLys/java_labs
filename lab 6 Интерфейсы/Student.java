import java.util.ArrayList;
import java.util.List;

public class Student extends Pupil implements PerformanceComparable {
    private List<Integer> examGrades;
    private List<Integer> courseworkGrades;

    public Student(String name, String surname, String gender, int age) throws InvalidDataException {
        super(name, surname, gender, age);
        this.examGrades = new ArrayList<>();
        this.courseworkGrades = new ArrayList<>();
    }

    public void addExamGrade(int grade) throws InvalidDataException {
        if (grade < 2 || grade > 5) {
            throw new InvalidDataException("Grade must be between 2 and 5.");
        }
        examGrades.add(grade);
    }

    public void addCourseworkGrade(int grade) throws InvalidDataException {
        if (grade < 2 || grade > 5) {
            throw new InvalidDataException("Grade must be between 2 and 5.");
        }
        courseworkGrades.add(grade);
    }

    @Override
    public boolean isEligibleForScholarship() {
        // Implement specific criteria for scholarship eligibility
        return false;
    }

    @Override
    public double getAcademicPerformanceRating() {
        if (examGrades.isEmpty() && courseworkGrades.isEmpty()) {
            return 0.0;
        }
        double examAverage = examGrades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        double courseworkAverage = courseworkGrades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        return (examAverage + courseworkAverage) / 2;
    }

    @Override
    public String toString() {
        return super.toString() + ", Student{" +
                "examGrades=" + examGrades +
                ", courseworkGrades=" + courseworkGrades +
                '}';
    }
}