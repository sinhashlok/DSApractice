package DSApractice.Sorting.Easy;

public class Keep_Multiplying_Found_Values_by_Two_2154 {

    public int findFinalValue(int[] nums, int original) {
        boolean[] h= new boolean[1001];
        for(int i : nums) {
            h[i] = true;
        }

        while(original <= 1000 && h[original])
            original *= 2;

        return original;
    }
}