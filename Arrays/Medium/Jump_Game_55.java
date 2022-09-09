package DSApractice.Arrays.Medium;

public class Jump_Game_55 {
    public static void main(String[] args) {
        int[] arr = {3,2,1,0,4};
        System.out.println(canJump(arr));
    }

    static int[] flag;
    // 0 - traversing first time
    // -1 - false, cannot reach end case
    // 1 - true, will reach end case
    static boolean canJump(int[] nums) {
        flag = new int[nums.length];

        return helper(nums, 0);
    }

    static boolean helper(int[] nums, int index) {
        if (index == nums.length - 1) {
            return true;
        } else if (index >= nums.length) {
            return false;
        }

        if (flag[index] == -1) {
            return false;
        }

        int jump = nums[index];
        if (jump == 0) {
            flag[index] = -1;
            return false;
        }

        while (true) {
            boolean temp = helper(nums, index + jump);
            jump--;

            if (temp) {
                flag[index + jump] = 1;
                return true;
            }

            if (jump == 0) {
                flag[index] = -1;
                return false;
            }
        }
    }
}