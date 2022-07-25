// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

package DSApractice.LeetCode.Bitwise.Easy;

public class Number_of_Steps_to_Reduce_a_Number_to_Zero_1342 {

    public int numberOfSteps(int num) {
        if (num == 0) return 0;

        return 1 + ((num % 2 == 0) ? numberOfSteps(num / 2) : numberOfSteps(num - 1));
                                    //      even                     odd
    }
}