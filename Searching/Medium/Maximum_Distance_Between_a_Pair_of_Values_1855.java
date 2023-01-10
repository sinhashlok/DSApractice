package DSApractice.Searching.Medium;

public class Maximum_Distance_Between_a_Pair_of_Values_1855 {

    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0, res = 0;

//        while nums1[i] is bigger than nums2[j], and increment j otherwise.
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                ++i;
            } else {
                res = Math.max(res, j++ - i);
            }
        }

        return res;
    }
}