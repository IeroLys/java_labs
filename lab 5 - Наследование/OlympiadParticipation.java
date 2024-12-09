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

    public int getPlace() {
        return place;
    }
}
