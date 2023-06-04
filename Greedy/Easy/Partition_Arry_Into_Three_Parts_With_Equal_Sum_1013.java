package DSApractice.Greedy.Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Partition_Arry_Into_Three_Parts_With_Equal_Sum_1013 {

    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int part = 0, average = sum / 3, count = 0;

        for (int a : arr) {
            part += a;

            if (part == average) {
                count++;
                part = 0;
            }
        }

        return count >= 3 && sum % 3 == 0;
    }
}