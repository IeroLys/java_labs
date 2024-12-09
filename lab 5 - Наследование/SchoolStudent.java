import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

// класс Школьник по заданию

public class SchoolStudent extends Pupil {
    private HashMap<String, Integer> subjectGrades;
    private List<OlympiadParticipation> olympiadParticipations;

    public SchoolStudent(String name, String gender, int age) {
        super(name, gender, age);
        this.subjectGrades = new HashMap<>();
        this.olympiadParticipations = new ArrayList<>();
    }

    public void addSubjectGrade(String subject, int grade) {
        subjectGrades.put(subject, grade);
    }

    public void addOlympiadParticipation(OlympiadParticipation participation) {
        olympiadParticipations.add(participation);
    }

    public List<OlympiadParticipation> getOlympiadParticipations() {
        return olympiadParticipations;
    }

    // 5 за все предметы: математика, русский, история, англ
    // остальные не ниже 4
    // участие в областной олимпиаде или первое место в школьной/призовое в городской
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
    public String toString() {
        return "SchoolStudent{" +
                "name='" + getName() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", age=" + getAge() +
                ", subjectGrades=" + subjectGrades +
                ", olympiadParticipations=" + olympiadParticipations +
                '}';
    }

}
