package DSApractice.LeetCode.Recursion.Easy;

public class Sumdigitofnumber {
    public static void main(String[] args) {
        int n = 45632;

        System.out.println(digits(n));
    }

    static int digits(int n) {
        if (n == 0)
            return 0;

        return (n % 10) + digits(n/10);
    }
}
