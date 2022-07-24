//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

package DSApractice.LeetCode.Arrays.Easy;

import java.util.ArrayList;
import java.util.List;

public class Kids_With_the_Greatest_Number_of_Candies_1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>(candies.length);
        int max = 0;

        for (int c : candies)
            max = Math.max(c, max);

        for (int i : candies)
            ans.add(i + extraCandies >= max);

        return ans;
    }
}
