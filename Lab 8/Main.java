public class Main {
    public static void main(String[] args) {
        // Problem 1
        TemperatureAnalysis temperatureAnalysis = new TemperatureAnalysis();
        System.out.println("Количество дней с отрицательной температурой: " + temperatureAnalysis.countNegativeDays());
        System.out.println("Были ли дни с температурой выше 10 градусов? " + temperatureAnalysis.hasTemperaturesAboveTen());
        System.out.println("Максимальная температура в первую неделю марта: " + temperatureAnalysis.getMaxTemperatureFirstWeek());
        System.out.println("Средняя температура за месяц: " + temperatureAnalysis.calculateAverageTemperature());

        // Problem 2
        String sentence = "They used 233 features including 227 stylometric features and six novel social " +
                "network-specific features like character-based ones numbers of alphabets, uppercase characters, " +
                "special characters, word-based ones the total number of words, average word length, the number of " +
                "words with 1 char, syntactic ones numbers of punctuation marks and functional words, the total number " +
                "of sentences and many others";
        SentenceAnalysis sentenceAnalysis = new SentenceAnalysis(sentence);

        System.out.println("\nКоличество слов, заканчивающихся на 'es': " + sentenceAnalysis.countWordsEndingWithEs());
        System.out.println("Слова, отсортированные по длине: " + sentenceAnalysis.getWordsSortedByLength());
        System.out.println("Сумма целых чисел в предложении: " + sentenceAnalysis.sumOfIntegersInSentence());
    }
}
