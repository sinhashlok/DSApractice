package DSApractice.LeetCode.Searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class FairCandySwap {
    public static void main(String[] args) {
        int[] alice = {14,54,83,100,72,1,91,60,13,71,94,28,58,63,61,34,55,93,56,17}, bob = {58,75,8,87,48,22,23,9,85,82,42,99,23,1,83,77,19,32,9,56};

        int[] arr = fairCandySwap(alice, bob);

        System.out.println(arr[0] + " " + arr[1]);
    }

    static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        // to find sum use Intstream
        int diff = (IntStream.of(aliceSizes).sum() - IntStream.of (bobSizes).sum()) / 2;

        Set<Integer> set = new HashSet<>();
        for (int x : aliceSizes)
            set.add(x);

        int[] arr = new int[2];
        for (int x : bobSizes)  // to see if the second person contains the required box
        {
            if (set.contains(x + diff))
            {
                arr[0] = x + diff;
                arr[1] = x;
                return arr;
            }
        }
        return arr;
    }

}
