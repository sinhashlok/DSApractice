package DSApractice.Sorting.Medium;

import java.util.Arrays;

public class Maximum_Bags_With_Full_Capacity_of_Rocks_2279 {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        // update capacity array with the space left in it to store more rocks
        for (int i = 0; i < capacity.length; i++) {
            capacity[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(capacity);
        // this allows all full bags to come in front

        int count = 0;
        for(int i = 0; i < capacity.length && (capacity[i] - additionalRocks) <= 0; i++) {
            additionalRocks -= capacity[i];
            count++;
        }

        return count;
    }
}