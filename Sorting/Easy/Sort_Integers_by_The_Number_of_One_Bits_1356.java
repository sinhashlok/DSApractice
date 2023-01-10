package DSApractice.Sorting.Easy;

import java.util.Arrays;

public class Sort_Integers_by_The_Number_of_One_Bits_1356 {

    public int[] sortByBits(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 10001;
        }

        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            arr[i] %= 10001;
        }

        return arr;
    }
}