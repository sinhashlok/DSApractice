package DSApractice.LeetCode.Sorting;

public class SpecialArrayXElementsGreaterThanEqualX_1608 {
    public static void main(String[] args) {
        int[] arr = {0,4,3,0,4};

        System.out.println(specialArray(arr));
    }

    static int specialArray(int[] nums) {
        int x = nums.length;
        int[] counts = new int[x+1];

        // keeps track of how many elements are greater than the index
        for(int elem : nums)
            if(elem >= x)
                counts[x]++;
            else
                counts[elem]++;

        int res = 0;
        for(int i = counts.length-1; i > 0; i--) {
            res += counts[i];
            if(res == i)    // when index matches number of elements greater -> result
                return i;
        }

        return -1;
    }
}
