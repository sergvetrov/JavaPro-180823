package HW6;

import java.util.*;

public class Task2 {

    private Task2() {
    }

    public static boolean containsDuplicate(int[] nums) {
        List<Integer> allNums = new ArrayList<>();
        LinkedHashSet<Integer> uniqueNums = new LinkedHashSet<>();
        for (int num : nums) {
            allNums.add(num);
            uniqueNums.add(num);
        }
        return !allNums.equals(new ArrayList<>(uniqueNums));
    }
}
