package DSApractice.LeetCode.Sorting;

public class SortArrayByParityII_922 {
    public static void main(String[] args) {
        int[] arr = {4,2,5,7};

        sortArrayByParityII(arr);

        for (int x : arr)
            System.out.print(x + " ");
    }

    static void sortArrayByParityII(int[] nums) {
        int index = 0;

        // only check for odd indices
        for (int i = 1; i < nums.length; i += 2)
        {
            if (nums[i] % 2 == 0)   // if even number
            {
                // find even indices without even number
                while (nums[index] % 2 == 0)
                    index += 2;

                swap(nums, i, index);
            }

            // if index is at the last even index, terminate, solution already reached
            if (index == nums.length - 2)
                break;
        }
    }

    static void swap(int[] nums, int i, int n) {
        int temp = nums[n];
        nums[n] = nums[i];
        nums[i] = temp;
    }
}
