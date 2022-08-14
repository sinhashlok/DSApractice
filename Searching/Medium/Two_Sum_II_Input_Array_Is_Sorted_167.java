// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

package DSApractice.Searching.Medium;

public class Two_Sum_II_Input_Array_Is_Sorted_167 {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, h = numbers.length - 1;
        int[] arr = {-1, -1};
        while (l < h)
        {
            if (numbers[l] + numbers[h] == target)
            {
                arr[0] = l + 1;
                arr[1] = h + 1;
                return arr;
            }
            else if (numbers[l] + numbers[h] > target)
                h--;
            else
                l++;
        }

        return arr;
    }

}
