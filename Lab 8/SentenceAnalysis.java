import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;

public class SentenceAnalysis {
    private String sentence;

    public SentenceAnalysis(String sentence) {
        this.sentence = sentence;
    }

// лямбда, считаем слова на "es"
    public int countWordsEndingWithEs() {
        return (int) Arrays.stream(sentence.split("[ ,]+"))
                .filter(word -> word.endsWith("es"))
                .count();
    }

// сортируем по длине слов
    public List<String> getWordsSortedByLength() {
        List<String> words = new ArrayList<>(Arrays.asList(sentence.split("[ ,]+")));
        words.sort(Comparator.comparingInt(String::length));
        return words;
    }

// считаем сумму целых чисел в предложении
    public int sumOfIntegersInSentence() {
        int sum = 0;
        Pattern pattern = Pattern.compile("-?\\d+"); // целые числа, включая отрицательные
        Matcher matcher = pattern.matcher(sentence);
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }
        return sum;
    }
}