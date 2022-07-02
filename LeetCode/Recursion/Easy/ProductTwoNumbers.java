package DSApractice.LeetCode.Recursion.Easy;

public class ProductTwoNumbers {
    public static void main(String[] args) {
        int x = 5, y = 2;
        System.out.println(product(x, y));
    }

    static int product(int x, int y) {
        // if x is less than
        // y swap the numbers
        if (x < y)
            return product(y, x);
        else if (y != 0)    // iteratively calculate y times sum of x
            return (x + product(x, y - 1));
        else                // if any of the two numbers is zero return zero
            return 0;
    }
}
