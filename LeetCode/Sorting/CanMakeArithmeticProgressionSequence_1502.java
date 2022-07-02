/*
0ms O(n) time and O(1) space based on coder206 idea, Step 1: Find min,max -> gap, then Step2: swap items in arr to right place.
    Edge Case: gap = 0 when all value is the same.
    Case 1: {1,1,1,1} same value
    Case 2: {1,2,5,7} meet with arr[i] which can not be put anywhere
    Case 3: {1,2,3,4} already at right place
    Case 4: {1,2,2,4} meet with duplicate
    Case 5: {2,1,3,4} -> {1,2,3,4} after swap 2 and 1, normal swap.
In the end, the arr should be like {min + 0gap, min + 1gap, min + 2*gap,..., min + (arr.length-1)*gap}
*/

package DSApractice.LeetCode.Sorting;

public class CanMakeArithmeticProgressionSequence_1502 {
    public static void main(String[] args) {
        int[] arr = {3,5,1};

        System.out.println(canMakeArithmeticProgression(arr));
    }

    static boolean canMakeArithmeticProgression(int[] arr) {
        // first find min and max
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num: arr)
        {
            max = Math.max(num,max);
            min = Math.min(num,min);
        }

        int gap = (max - min)/(arr.length - 1);
        if(max - min != gap * (arr.length - 1))
            return false;

        //Case 1: {1,1,1,1} or {0,0,0,0}
        if(gap == 0 && min == max)
            return true;

        //swap each num to according place
        //min + 0*gap, min + 1*gap, min + 2*gap,..., min + (arr.length-1)*gap
        for(int i = 0; i < arr.length;)
        {
            //Case 2: {1,2,5,7} meet with arr[i] which can not be put anywhere
            if((arr[i] - min) % gap != 0)
                return false;
            int index = (arr[i] - min) / gap;

            //Case 3: {1,2,3,4} -> {1,2,3,4} i++ when arr[i] is at the right place
            if(index == i)
                i++;
            else
            {
                //Case 4: {1,2,2,4} meet with duplicate
                if(arr[index] == arr[i])
                    return false;

                //Case 5: {2,1,3,4} -> {1,2,3,4} after swap 2 and 1
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }

        return true;
    }
}
