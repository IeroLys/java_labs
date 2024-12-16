public abstract class Pupil implements Comparable<Pupil> {
    private String name;
    private String surname;
    private String gender;
    private int age;

    public Pupil(String name, String surname, String gender, int age) throws InvalidDataException {
        if (!Character.isUpperCase(name.charAt(0)) || !name.matches("[A-Za-z]+")) {
            throw new InvalidDataException("Name must start with an uppercase letter and contain only letters.");
        }
        if (!surname.matches("[A-Za-z]+")) {
            throw new InvalidDataException("Surname must contain only letters.");
        }
        if (age <= 0) {
            throw new InvalidDataException("Age must be positive.");
        }
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

// для сортировки по фамилиям в 1 задании
    @Override
    public int compareTo(Pupil other) {
        return this.surname.compareTo(other.getSurname());
    }

    public abstract boolean isEligibleForScholarship();

    public abstract double getAcademicPerformanceRating();

    /*@Override
    public String toString() {
        return "Name: " + name +
                "\nSurname: " + surname +
                "\nGender: " + gender +
                "\nAge: " + age;
    }*/
}