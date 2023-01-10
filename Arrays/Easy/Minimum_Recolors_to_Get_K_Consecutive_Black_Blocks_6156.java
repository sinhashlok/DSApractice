package DSApractice.Arrays.Easy;

public class Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks_6156 {
    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
    }

    static int minimumRecolors(String blocks, int k) {
        int res = 0, count = 0;

        if (k == blocks.length()) {
            for (int i = 0; i < blocks.length(); i++) {
                if (blocks.charAt(i) == 'W') {
                    count ++;
                }
            }

            return count;
        }

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                count ++;
            }
        }

        res = count;
        int l = 1, r = k;
        while (r < blocks.length()) {
            if (blocks.charAt(l - 1) == 'W') {
                count--;
            }
            if (blocks.charAt(r) == 'W') {
                count++;
            }

            res = Math.min(res, count);
            l++;
            r++;
        }

        return res;
    }
}