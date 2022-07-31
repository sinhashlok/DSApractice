// https://leetcode.com/problems/plus-one/

package DSApractice.LeetCode.Arrays.Easy;

public class Plus_One_66 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }
        // if above return statement is not true
        int[] newNumber = new int [digits.length + 1];
        newNumber[0] = 1;

        return newNumber;
    }
}
