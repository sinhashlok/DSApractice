package DSApractice.Greedy.Medium;

import java.util.Arrays;

public class Bag_of_Tokens_948 {

    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        Arrays.sort(tokens);
        int l = 0, r = tokens.length - 1;

        while (r >= l) {
            if (power >= tokens[l]) {
                power -= tokens[l];
                score++;
                l++;
            } else {
                if (score == 0 || l == r) {
                    return score;
                }
                power += tokens[r];
                score--;
                r--;
            }
        }

        return score;
    }
}