package DSApractice.Bitwise.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());   // add empty subset

        int start = 0, end = 0;
        // start and help in preventing duplicated subsets

        for (int i = 0; i < nums.length; i++) {
            start = 0;

            // if current and previous element is same, s = e + 1
            // this allows use to skip copying the subsets, due to which duplicated subsets can be generated
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = end + 1;
            }

            end = outer.size() - 1;
            int n = outer.size();

            for (int j = start; j < n; j++) {
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(nums[i]);
                outer.add(internal);
            }
        }

        return outer;
    }
}