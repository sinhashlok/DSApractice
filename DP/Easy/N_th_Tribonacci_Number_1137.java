package DSApractice.DP.Easy;

public class N_th_Tribonacci_Number_1137 {

    public int tribonacci(int n) {
        int prev3 = 0;
        int prev2 = 1;
        int prev1 = 1;

        if (n <= 2) {
            if (n == 0) {
                return 0;
            } else {
                return 1;
            }
        }

        int curr = 0;
        for (int i = 3; i <= n; i++) {
            curr = prev1 + prev2 + prev3;

            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }
}