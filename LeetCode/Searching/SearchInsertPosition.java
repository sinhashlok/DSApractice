package DSApractice.LeetCode.Searching;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int k = 2;

        // Function Call
        System.out.println("Missing kth number = "+ searchInsert(arr, k));
    }

    static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        // Invariant: the desired index is between [low, high+1]
        int l = 0, h = nums.length - 1, m;

        while (l <= h)
        {
            m = l + (h - l) / 2;

            if (nums[m] < target)
                l = m + 1;
            else
                h = m - 1;
        }
// (1) At this point, low > high. That is, low >= high+1
        // (2) From the invariant, we know that the index is between [low, high+1], so low <= high+1. Follwing from (1), now we know low == high+1.
        // (3) Following from (2), the index is between [low, high+1] = [low, low], which means that low is the desired index
        //     Therefore, we return low as the answer. You can also return high+1 as the result, since low == high+1
        return l;
    }
}
