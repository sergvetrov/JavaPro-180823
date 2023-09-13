package HW5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListService {

    private ListService() {
    }

    public static int countOccurance(List<String> words, String target){
        int count = 0;
        for (String word : words){
            if(word.equals(target)) count++;
        }
        return count;
    }

    public static List<String> toList(String[] words){
        return Arrays.asList(words);
    }

    public static List<Integer> findUnique(List<Integer> numbers){
        List<Integer> unique = new ArrayList<>();
        for (Integer number : numbers) {
            if(!unique.contains(number)) unique.add(number);
        }
        return unique;
    }

    public static void calcOccurance(List<String> words){
        List<String> colector = new ArrayList<>();
        for (String word : words) {
            if(colector.contains(word)) continue;
            int counter = 0;
            for (String w : words) if(w.equals(word)) counter++;
            System.out.println(word + ": " + counter);
            colector.add(word);
        }
    }

    public static List<String> findOccurance(List<String> words){
        List<String> result = new ArrayList<>();
        List<String> colector = new ArrayList<>();
        for (String word : words) {
            if(colector.contains(word)) continue;
            int counter = 0;
            for (String w : words) if(w.equals(word)) counter++;
            result.add("name: " + "\"" + word + "\", " + "occurrence:" + counter);
            colector.add(word);
        }
        return result;
    }
}
