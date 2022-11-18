package DSApractice.Math.Easy;

public class Ugly_Number_263 {

    public boolean isUgly(int n) {
        if (n > 0) {
            for (int i=2; i<6; i++) {
                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        return n == 1;
    }
}
