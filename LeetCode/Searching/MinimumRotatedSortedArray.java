package DSApractice.LeetCode.Searching;

public class MinimumRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};

        System.out.println(miniEle(arr));
    }

    static int miniEle(int[] nums)
    {
        // if list has just one element -> return the element
        if (nums.length == 1)
            return nums[0];

        int l = 0, r = nums.length - 1;

        // if last element is greater than the first -> array is not rotated
        // hence first element is the minimum
        if (nums[r] > nums[0])
            return nums[0];

        // binary search
        while (l <= r)
        {
            int m = l + (r - l) / 2;

            // if the mid element is greater than its next element then mid+1 element is the smallest
            // This point would be the point of change. From higher to lower value.
            if (nums[m] > nums[m+1])
                return nums[m + 1];

            // if the mid element is lesser than its previous element then mid element is the smallest
            if (nums[m-1] > nums[m])
                return nums[m];


            // if the middle elements value is greater than the 0th element this means
            // the least value is still somewhere to the right as we are still dealing with elements
            // greater than nums[0]
            if (nums[m] > nums[l])
                l = m + 1;
            else
                r = m - 1;
        }

        return -1;
    }
}
