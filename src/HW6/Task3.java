package HW6;

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
}
