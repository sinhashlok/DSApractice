package DSApractice.LeetCode.Arrays.Easy;

public class Pivot_index {
    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};

        System.out.println(pivotIndex(arr));
    }

    static int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
