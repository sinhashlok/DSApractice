package DSApractice.Bitwise.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class Bitwise_XOR_of_All_Pairings_6213 {

    public static void main(String[] args) {
        int[] nums1 = {8,6,29,2,26,16,15,29}, nums2 = {24,12,12,12};
        System.out.println(xorAllNums(nums1, nums2));
    }

    static int xorAllNums(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = 1; i <  nums1.length; i++) {
            if (nums1[i] == nums1[i - 1]) {
                nums1[i - 1] = -1;
                nums1[i] = -1;
            }
        }

        for (int i = 1; i <  nums2.length; i++) {
            if (nums2[i] == nums2[i - 1]) {
                nums2[i - 1] = -1;
                nums2[i] = -1;
            }
        }

        int xor = 0;

        for (int i : nums1) {
            if (i == -1) {
                continue;
            }
            for (int j : nums2) {
                if (j == -1) {
                    continue;
                }

                xor = (xor) ^ (i ^ j);
            }
        }

        return xor;
    }
}