package DSApractice.Searching.Medium;

public class Reach_a_Number_754 {

    public int reachNumberLeet(int target) {
        target = Math.abs(target);
        int k = 0;

        while (target > 0) {
            k += 1;
            target -= k;
        }

        return target % 2 == 0 ? k : k + 1 + k % 2;
    }

    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0, sum = 0;

        while (sum < target) {
            step++;
            sum += step;
        }

        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }

        return step;
    }
}