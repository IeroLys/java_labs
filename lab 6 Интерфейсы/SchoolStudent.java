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
        String[] requiredSubjects = {"math", "russian", "history", "english"};
        for (String subject : requiredSubjects) {
            if (!subjectGrades.containsKey(subject) || subjectGrades.get(subject) != 5) {
                return false;
            }
        }
        for (int grade : subjectGrades.values()) {
            if (grade < 4) {
                return false;
            }
        }
        for (OlympiadParticipation participation : olympiadParticipations) {
            if (participation.getLevel() == OlympiadLevel.REGIONAL) {
                return true;
            } else if (participation.getLevel() == OlympiadLevel.SCHOOL && participation.getPlace() == 1) {
                return true;
            } else if (participation.getLevel() == OlympiadLevel.CITY && participation.getPlace() <= 3) {
                return true;
            }
        }
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
        return super.toString() +
                "\nSchool Number: " + schoolNumber +
                "\nSubject Grades: " + subjectGrades +
                "\nOlympiad Participations: " + olympiadParticipations;
    }
}