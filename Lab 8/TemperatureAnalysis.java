import java.util.Arrays;

public class TemperatureAnalysis {
    private static final int[] temperatures = {-2, -5, -2, -4, 3, -6, -2, -1, 5, 1, 1, 0, -1, 0, 3, -1, 2, 5, 2, 4, 4, 0, 6, 1, 4, 6, -1, 2, 4, 7, 11};

    public int countNegativeDays() {
        return (int) Arrays.stream(temperatures).filter(temp -> temp < 0).count();
    }

    public boolean hasTemperaturesAboveTen() {
        return Arrays.stream(temperatures).anyMatch(temp -> temp > 10);
    }

    public int getMaxTemperatureFirstWeek() {
        return Arrays.stream(temperatures, 0, 7).max().orElse(Integer.MIN_VALUE);
    }

    public double calculateAverageTemperature() {
        return Arrays.stream(temperatures).average().orElse(0.0);
    }
}