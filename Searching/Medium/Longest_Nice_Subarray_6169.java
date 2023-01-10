package DSApractice.Searching.Medium;

public class Longest_Nice_Subarray_6169 {

    public int longestNiceSubarray(int[] nums) {
        int res = 1, mod;

        int l = 0, r = 1;
        while (r < nums.length) {
            if (l == r) {
                r++;
                continue;
            }

            if (getMod(nums, l, r)) {
                res = Math.max(res, r - l + 1);
                r++;
            } else {
                l++;
                r++;
            }
        }

        return res;
    }

    private boolean getMod(int[] nums, int l, int r) {
        int mod = 1;

        for (int i = l; i < r; i++) {
            int x = i + 1;

            while (x <= r) {
                mod = nums[i];
                mod = mod & nums[x];
                x++;

                if (mod != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}