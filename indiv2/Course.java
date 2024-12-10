public class Course {
    private String id;
    private String name;
    private String url;
    private boolean isFree;
    private double cost;
    private int numberOfStudents;
    private int numberOfReviews;
    private int numberOfLectures;
    private String difficulty;
    private int durationMonths;

// конструктор
    public Course(String id, String name, String url, boolean isFree, double cost,
                  int numberOfStudents, int numberOfReviews, int numberOfLectures,
                  String difficulty, int durationMonths) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.isFree = isFree;
        this.cost = cost;
        this.numberOfStudents = numberOfStudents;
        this.numberOfReviews = numberOfReviews;
        this.numberOfLectures = numberOfLectures;
        this.difficulty = difficulty;
        this.durationMonths = durationMonths;
    }

    // Геттеры для получения данных

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public boolean isFree() {
        return isFree;
    }

    public double getCost() {
        return cost;
    }

    public int getNumberOfLectures() {
        return numberOfLectures;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

// чтоб красиво вывести
    @Override // переопределяем унаследованный метод
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", isFree=" + isFree +
                ", cost=" + cost +
                ", numberOfStudents=" + numberOfStudents +
                ", numberOfReviews=" + numberOfReviews +
                ", numberOfLectures=" + numberOfLectures +
                ", difficulty='" + difficulty + '\'' +
                ", durationMonths=" + durationMonths +
                '}';
    }
}
