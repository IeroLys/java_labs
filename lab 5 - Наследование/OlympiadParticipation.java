public class OlympiadParticipation {
    private OlympiadLevel level;
    private int place;

    public OlympiadParticipation(OlympiadLevel level, int place) {
        this.level = level;
        this.place = place;
    }

    public OlympiadLevel getLevel() {
        return level;
    }

    public void setLevel(OlympiadLevel level) {
        this.level = level;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }
}