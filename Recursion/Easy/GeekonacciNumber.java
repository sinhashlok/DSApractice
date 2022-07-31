/* https://practice.geeksforgeeks.org/problems/geek-onacci-number/0/#

    Geek created a random series and given a name geek-onacci series. Given four integers A, B, C, N.
    A, B, C represents the first three numbers of geek-onacci series.
    Find the Nth number of the series. The nth number of geek-onacci series is a sum of the last
    three numbers (summation of N-1th, N-2th, and N-3th geek-onacci numbers)

Input:
    3
    1 3 2 4
    1 3 2 5
    1 3 2 6

Output:
    6
    11
    19
*/
package DSApractice.LeetCode.Recursion.Easy;

import java.util.Scanner;

public class GeekonacciNumber {
    public static void main(String[] args) {
        Scanner
                in = new Scanner(System.in);

        int t = in.nextInt();

        while (t-- > 0)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int n = in.nextInt();

            System.out.println(geekonacciNum(a,b,c,n));
        }
        in.close();
    }

    static int geekonacciNum(int a, int b, int c, int n) {
        if (n == 1)
            return a;
        else if (n == 2)
            return b;
        else if (n == 3)
            return c;

        return geekonacciNum(a,b,c, n - 1) + geekonacciNum(a,b,c, n - 2) + geekonacciNum(a,b,c, n - 3);
    }
}
