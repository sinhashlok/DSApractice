package DSApractice.Searching.Hard;

public class Median_of_Two_Sorted_Arrays_4 {


    /* We need time complexity to be: O(log(n + m))
    *
    * We need to find the median such that answer would be same if both arrays were merged in sorted order
    * So, we try to maintain a left half and right half both the halves contain some element of
    * first and second array in left and some in right.
    *
    * Each half is such that left and right both have half element from first array and second array
    * # we want half of  (m + n) elements in left half, and half on right half.
    *
    * We binary search in smaller array.
    *   l ...... m ...... r (for start l = 0, r = first arr.length)
    *   so left half will have elements from 0 - index to m (l and r will only be used to get middle element in index)
    *   right half will have  form m + 1 to r
    * we do not need to run binary search in second array
    * for second array we would need first, m - l elements => so that total element on left half  = right half = (m + n)/2
    *
    * How to know if the left partition is correct?
    *   - we want to make sure that last element in left partition is less than or equal to every element in right partition.
    *   - We have to check if the left most element in first array (middle element) less than or equal to the next element in second array.
    *   - Same goes the right most element of the left half in the second array.
    *   - if not (for any) => Not partitioned correctly
    *       we are going to left shift l to m + 1, in the binary search array.
    *
    * Our median would be the left most element in the right interval.
    *
    * ODD no. of elements: take the min of both the values of the left most element in the right interval form both the array.
    * EVEN no. of elements: take max from left partition, and min from right partition, then add and divide by 2.
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length <= nums2.length) {
            return median(nums1, nums2);
        }

        return median(nums2, nums1);
    }

    public double median(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int l = 0, r = n1;

        while (l <= r) {
            // get i1 & i2
            int i1 = l + (r - l) / 2;
            int i2 = ((n1 + n2 + 1) / 2) - i1;

            // min & max
            /* min1: Minimum element in right side of nums1
             * min2: Minimum element in right side of nums2
             * max1: Maximum element in left side of nums1
             * max2: Maximum element in left side of nums2
             */
            int min1 = (i1 == n1) ? Integer.MAX_VALUE : nums1[i1];
            int max1 = (i1 == 0) ? Integer.MIN_VALUE : nums1[i1 - 1];
            int min2 = (i2 == n2) ? Integer.MAX_VALUE : nums2[i2];
            int max2 = (i2 == 0) ? Integer.MIN_VALUE : nums2[i2 - 1];

            // check
            if ( max1 <= min2 && max2 <= min1) {
                if ((n1 + n2) % 2 == 0) {
                    return ((double)(Math.max(max1, max2) + Math.min(min1, min2))) / 2;
                }
                else {
                    return Math.max(max1, max2);
                }
            }
            else if (max1 > min2) {
                r = i1 - 1;
            }
            else {
                l = i1 + 1;
            }
        }

        return -1;
    }
}