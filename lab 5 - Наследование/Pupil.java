// класс Учащийся по заданию

public abstract class Pupil {
    private String name; // имя
    private String gender; // пол
    private int age; // возраст

    public Pupil(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract boolean isEligibleForScholarship();

    public abstract String toString();
}
