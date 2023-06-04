// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description/

package DSApractice.Greedy.Medium;

public class Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers_1689 {

    public int minPartitions(String n) {
        int count = 0;
        for (int i = 0; i < n.length(); i++) {
            count = Math.max(count, (int)(n.charAt(i) - '0'));
        }

        return count;
    }
}