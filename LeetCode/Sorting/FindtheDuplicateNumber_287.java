package DSApractice.LeetCode.Sorting;

public class FindtheDuplicateNumber_287 {
    public static void main(String[] args) {
        int[] arr = {8,7,1,10,17,15,18,11,16,9,19,12,5,14,3,4,2,13,18,18};

        System.out.println(findDuplicate(arr));
    }

    static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length)
        {
            if (nums[i] != i + 1)
            {
                if (nums[i] != nums[nums[i] - 1])
                    swap(nums, i, nums[i] - 1);
                else
                    return nums[i];
            }
            else
                i++;
        }

        return -1;
    }

    static void swap(int[] nums, int i, int x) {
        int temp = nums[i];
        nums[i] = nums[x];
        nums[x] = temp;
    }
}
