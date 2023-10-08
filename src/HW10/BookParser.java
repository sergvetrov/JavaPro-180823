package HW10;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookParser {

    public static void makeStatistic(String bookName) throws IOException {
        File statistic = new File("src/HW10/resources/" + bookName + "_statistic.txt");
        FileWriter statisticWriter = new FileWriter(statistic);
        BufferedWriter bufferedStatistic = new BufferedWriter(statisticWriter);

        String[] parsedBook = parse(bookName);
        Map<String, Long> top10words = top10PopularWords(parsedBook);

        System.out.println("Statistic of this book:");
        top10words.entrySet().forEach(System.out::println);
        bufferedStatistic.write("Statistic of book - " + bookName);
        bufferedStatistic.newLine();
        for (Map.Entry<String, Long> entry : top10words.entrySet()) {
            bufferedStatistic.write(entry.getValue() + " -> " + entry.getKey());
            bufferedStatistic.newLine();
        }

        int totalWords = totalUnique(parsedBook);
        String resultWords = "total unique words = " + totalWords;
        System.out.println(resultWords);
        bufferedStatistic.write(resultWords);
        bufferedStatistic.close();
    }

    private static String[] parse(String bookName) throws IOException {
        File book = new File("src/HW10/resources/" + bookName + ".txt");
        try (FileReader bookReader = new FileReader(book)) {
            char[] bookSymbols = new char[(int) book.length()];
            bookReader.read(bookSymbols);

            return new String(bookSymbols)
                    .replaceAll("[^a-zA-Z\s]", "")
                    .toLowerCase()
                    .split(" ");
        }
    }

    private static Map<String, Long> top10PopularWords(String[] words) {
        Map<String, Long> allWords = Arrays.stream(words)
                .filter(p -> p.length() > 2)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));

        return allWords.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
    }

    private static int totalUnique(String[] words) {
        return Arrays.stream(words).collect(Collectors.toSet()).size();
    }
}
