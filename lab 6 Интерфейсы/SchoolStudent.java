import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;


public class SchoolStudent extends Pupil implements PerformanceComparable { // реализовываем интерфейс
    private HashMap<String, Integer> subjectGrades;
    private List<OlympiadParticipation> olympiadParticipations;
    private int schoolNumber;

// конструктор
    public SchoolStudent(String name, String surname, String gender, int age, int schoolNumber) throws InvalidDataException {
// вызываем конструктор суперкласса и передаём ему значения
// школьник - учащийся
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

    public HashMap<String, Integer> getSubjectGrades() {
        return subjectGrades;
    }

    public List<OlympiadParticipation> getOlympiadParticipations() {
        return olympiadParticipations;
    }

    @Override
    public boolean isEligibleForScholarship() {
// необходимые предметы
        String[] requiredSubjects = {"math", "russian", "history", "english"};
// если нет необходимого предмета или оценка не 5
        for (String subject : requiredSubjects) {
            if (!subjectGrades.containsKey(subject) || subjectGrades.get(subject) != 5) {
                return false;
            }
        }
// оценка по другому предмету < 4
        for (int grade : subjectGrades.values()) {
            if (grade < 4) {
                return false;
            }
        }

// участие в регионе
// городской уровень 1, 2, 3 места
// школьный 1 место
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
// вычисляем среднее значение
        return subjectGrades.values().stream().mapToInt(Integer::intValue).average().orElse(0.0);
// получаем оценки, создаём поток значений, преобразуем в int, считаем среднее
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nSurname: %s\nGender: %s\nAge: %d\nSchool Number: %d\nSubject Grades: %s\nOlympiad Participations: %s",
                getName(), getSurname(), getGender(), getAge(), getSchoolNumber(), subjectGrades, olympiadParticipations);
    }
}