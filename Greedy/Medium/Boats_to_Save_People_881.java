// https://leetcode.com/problems/boats-to-save-people/description/

package DSApractice.Greedy.Medium;

import java.util.Arrays;

public class Boats_to_Save_People_881 {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        // if minimum weight of the people is equal to limit
        // then one boat can carry one person
        if (people[0] >= limit) {
            return people.length;
        }

        // we will use two-pointers one for minimum weight and other maximum
        // we fix minimum weight and find the maximum weight that can be accommodated with it
        int i = 0, j = people.length - 1;
        int boats = 0;

        while (i <= j) {
            boats++;
            if (people[i] + people[j] <= limit) {
                i++;
            }

            j--;
        }

        return boats;
    }
}