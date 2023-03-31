package DSApractice.DP.Easy;

public class Divisor_Game_1025 {

    // Math / logic
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    // Linear DP
    public boolean divisorGameDP(int n) {
        if (n == 1 || n == 3) {
            return false;
        }
        else if (n == 2) {
            return true;
        }

        boolean[] dp = new boolean[n + 1];
        dp[2] = true;

        for (int i = 4; i < n + 1; i++) {
            for (int j = 2; j <= i / 2; j++) {
                if ((i % j == 0) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}