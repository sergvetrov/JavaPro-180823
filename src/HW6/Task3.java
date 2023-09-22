package HW6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Task3 {

    private Task3() {
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; nums.length >= i; i++) {
            for (int j = i + 1; nums.length - 1 >= j; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

//    public static int[] twoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> collector = new HashMap<>();
//        for (int number : nums) {
//            if (collector.containsKey(number)) {
//                List<Integer> ints = new ArrayList<>();
//                for (int num : nums) {
//                    ints.add(num);
//                }
//                return new int[]{ints.indexOf(number), ints.indexOf(collector.get(number))};
//            } else {
//                collector.put(target - number, number);
//            }
//        }
//        return null;
//    }

//    public static int[] twoSum(int[] nums, int target) {
//        int[] nums2 = Arrays.copyOf(nums, nums.length);
//        Arrays.sort(nums);
//        int left = 0;
//        int right = nums.length - 1;
//        while (nums[left] < nums[right]) {
//            int total = nums[left] + nums[right];
//            if (total > target) {
//                right--;
//            } else if (total < target) {
//                left++;
//            } else {
//                List<Integer> ints = new ArrayList<>();
//                for (int num : nums2) {
//                    ints.add(num);
//                }
//                return new int[] {ints.indexOf(nums[left]), ints.indexOf(nums[right])};
//            }
//        }
//        return null;
//    }

}
