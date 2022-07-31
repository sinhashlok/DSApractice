// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/

package DSApractice.LeetCode.Arrays.Easy;

public class Minimum_Cost_to_Move_Chips_to_The_Same_Position_1217 {

    public int minCostToMoveChips(int[] position) {
        int e = 0, o = 0;

        for (int x : position) {
            if ((x & 1) == 0)
                e ++;
            else
                o ++;
        }

        if (e > o)
            return o;
        else
            return e;
    }
}
