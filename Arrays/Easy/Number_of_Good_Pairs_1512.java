// https://leetcode.com/problems/number-of-good-pairs/

package DSApractice.LeetCode.Arrays.Easy;

public class Number_of_Good_Pairs_1512 {
    public int numIdenticalPairs(int[] nums) {
        int res = 0, count[] = new int[101];
        for (int a: nums) {
            res += count[a]++;
        }
        return res;
    }
}
