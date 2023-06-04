// https://leetcode.com/problems/gas-station/description/

package DSApractice.Greedy.Medium;

public class Gas_Station_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int netGas = 0;
        int gasLeft = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            netGas += gas[i] - cost[i];
            gasLeft += gas[i] - cost[i];

            if (gasLeft < 0) {
                gasLeft = 0;
                start = i + 1;
            }
        }

        return netGas < 0 ? -1 : start;
    }
}