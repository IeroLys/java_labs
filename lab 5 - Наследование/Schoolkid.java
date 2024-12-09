import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schoolkid extends Student {
    private Map<String, Integer> subjectGrades;
    private List<OlympiadParticipation> olympiadParticipations;

    public Schoolkid(String name, String gender, int age) {
        super(name, gender, age);
        this.subjectGrades = new HashMap<>();
        this.olympiadParticipations = new ArrayList<>();
    }

    // Getters and setters for subjectGrades and olympiadParticipations

    public Map<String, Integer> getSubjectGrades() {
        return subjectGrades;
    }

    public void setSubjectGrades(Map<String, Integer> subjectGrades) {
        this.subjectGrades = subjectGrades;
    }

    public List<OlympiadParticipation> getOlympiadParticipations() {
        return olympiadParticipations;
    }

    public void setOlympiadParticipations(List<OlympiadParticipation> olympiadParticipations) {
        this.olympiadParticipations = olympiadParticipations;
    }

    @Override
    public boolean isEligibleForScholarship() {
        // Check for grades
        String[] requiredSubjects = {"math", "russian", "history", "english"};
        for (String subject : requiredSubjects) {
            if (!subjectGrades.containsKey(subject) || subjectGrades.get(subject) != 5) {
                return false;
            }
        }
        // Check other grades not lower than 4
        for (Integer grade : subjectGrades.values()) {
            if (grade < 4) {
                return false;
            }
        }
        // Check Olympiad participations
        boolean olympiadCondition = false;
        for (OlympiadParticipation participation : olympiadParticipations) {
            if (participation.getLevel() == OlympiadLevel.REGIONAL) {
                olympiadCondition = true;
                break;
            } else if (participation.getLevel() == OlympiadLevel.SCHOOL && participation.getPlace() == 1) {
                olympiadCondition = true;
                break;
            } else if (participation.getLevel() == OlympiadLevel.CITY && participation.getPlace() >= 1 && participation.getPlace() <= 3) {
                olympiadCondition = true;
                break;
            }
        }
        return olympiadCondition;
    }
}