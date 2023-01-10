package DSApractice.Arrays.Easy;

public class Max_Consecutive_Ones_485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, cnt = 0;
        for (int i : nums) {
            if (i == 1) {
                cnt += 1;
                res = Math.max(cnt, res);
            } else {
                cnt = 0;
            }
        }

        return res;
    }
}