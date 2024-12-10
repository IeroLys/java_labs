import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class SchoolStudent extends Pupil implements PerformanceComparable {
    private HashMap<String, Integer> subjectGrades;
    private List<OlympiadParticipation> olympiadParticipations;
    private int schoolNumber;

    public SchoolStudent(String name, String surname, String gender, int age, int schoolNumber) throws InvalidDataException {
        super(name, surname, gender, age);
        this.subjectGrades = new HashMap<>();
        this.olympiadParticipations = new ArrayList<>();
        if (schoolNumber <= 0) {
            throw new InvalidDataException("School number must be positive.");
        }
        this.schoolNumber = schoolNumber;
    }

    public void addSubjectGrade(String subject, int grade) throws InvalidDataException {
        if (grade < 2 || grade > 5) {
            throw new InvalidDataException("Grade must be between 2 and 5.");
        }
        subjectGrades.put(subject, grade);
    }

    public void addOlympiadParticipation(OlympiadParticipation participation) {
        olympiadParticipations.add(participation);
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    @Override
    public boolean isEligibleForScholarship() {
        // Implement specific criteria for scholarship eligibility
        return false;
    }

    @Override
    public double getAcademicPerformanceRating() {
        if (subjectGrades.isEmpty()) {
            return 0.0;
        }
        return subjectGrades.values().stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    @Override
    public String toString() {
        return super.toString() + ", SchoolStudent{" +
                "schoolNumber=" + schoolNumber +
                ", subjectGrades=" + subjectGrades +
                ", olympiadParticipations=" + olympiadParticipations +
                '}';
    }
}