package DSApractice.Searching.Medium;

public class Ways_to_Split_Array_Into_Three_Subarrays_1712 {

//    public int waysToSplit(int[] nums) {
//        for (int i = 1; i < nums.length; i++) {
//            nums[i] += nums[i - 1];
//        }
//
//        int count = 0;
//        for (int i = 0; i < nums.length - 2; i++) {
//            int l = i, r = nums.length - 1, m = 0;
//            int sum1 = 0, sum2 = 0;
//            while (l < r) {
//                m = l + (r - l) / 2;
//
//                sum1 = nums[m] - nums[i];
//                sum2 = nums[nums.length - 1] - nums[m];
//
//                if (nums[i] <= sum1 && sum1 <= sum2) {
//                    l = m + 1;
//                } else {
//                    r = m;
//                }
//            }
//            l--;
//
//            sum1 = nums[l] - nums[i];
//            sum2 = nums[nums.length - 1] - nums[l];
//            if (nums[i] <= sum1 && sum1 <= sum2) {
//
//            }
//        }
//    }
}