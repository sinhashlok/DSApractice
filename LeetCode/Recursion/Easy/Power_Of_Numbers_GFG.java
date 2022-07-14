// https://practice.geeksforgeeks.org/problems/power-of-numbers-1587115620/1/?page=1&difficulty[]=0&category[]=Recursion&sortBy=accuracy

package DSApractice.LeetCode.Recursion.Easy;

public class Power_Of_Numbers_GFG {
    public static void main(String[] args) {
        System.out.println(power(39907139, 93170993));
    }

    static long power(long x, long y)
    {
        long result = 1;
        while (y > 0) {
            if(y%2!=0) // y is odd
            {
                result=(result*x) % 1000000007;
            }
            x = (x*x)%1000000007;
            y=y>>1; // y=y/2;
        }
        return result;
    }
}
