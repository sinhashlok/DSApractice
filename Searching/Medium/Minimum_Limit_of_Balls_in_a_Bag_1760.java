package DSApractice.Searching.Medium;

public class Minimum_Limit_of_Balls_in_a_Bag_1760 {


    /*
    * minimum possible penalty - 1
    * maximum possible penalty - max element
    *
    * we create a helper function which tells:
    * if it is possible to get a certain penalty considering the max number of operations allowed,
    * we can perform binary search on above range to minimize the possible penalty.
    * */
    public int minimumSize(int[] nums, int maxOperations) {
        int r = Integer.MIN_VALUE;
        for (int i : nums) {
            r = Math.max(r, i);
        }

        int l = 1, minPenalty = r;  // r = max_element
        int penalty = 0;    // mid
        // binary search on all possible range
        while (l <= r) {
            penalty = l + (r - l) / 2;

            if (solution(nums, maxOperations, penalty)) {
                minPenalty = penalty;
                r = penalty - 1;
            } else {
                l = penalty + 1;
            }
        }

        return minPenalty;
    }

    private boolean solution(int[] nums, int maxOperations, int penalty) {
        int ops = 0;    // required operations

        for (int i : nums) {
            // no. of operations required to bring n less than or eq to curr assumed penalty
            int x = i / penalty;

            // if n is divisible by penalty, need to subtract 1
            if (i % penalty == 0) x--;
            ops += x;
        }

        return ops <= maxOperations;
    }
}