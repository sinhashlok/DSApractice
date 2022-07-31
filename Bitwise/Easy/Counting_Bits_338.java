// https://leetcode.com/problems/counting-bits/
/*
*
* Even
    if you have any even no. let's say 4. So, you want the answer of 4. Whatever the answer of 4 is the answer of 2 as well.
    So, i can say that even = n / 2

* Odd
    so to get the value of odd. It's very simple as well. For odd = 1 + n / 2 let's say for 5,
    what ever the answer of 5 os the answer of 3 as well.

* Modification
    But, there is one problem in this code, although it will run very well.
    Let's understand what the issue is:
    Let's assume n is 15

    For n = 15, we have to make recursive tree for every value from 15->14->13 ----- > 0

    As you can see, we are repeating the calculation for every value. If we store our fewer down value then
    we don't need to calculate again for them, we simply return our answer.
    Example :- for 15 going to 7 all the way to 1.But in 14 if you see we have already calculated for 7.
    Then we don't want to repeat for 15, we simply return our answer from there.
    By doing that we can save so many recursive call.
* * */
package DSApractice.LeetCode.Bitwise.Easy;

public class Counting_Bits_338 {
    public static void main(String[] args) {
        int[] res = countBits(7);
    }

    static int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 0; i <= n; i++){
            res[i] = solve(i, res);
        }
        return res;
    }

    //recursive solution
    static int solve(int n, int[] memo) {

        if (n == 0) return 0;   // even
        if (n == 1) return 1;   // odd

        if (memo[n] != 0) return memo[n];   // modification
        // if memo of n answer is already available we will re-use it & not go further for calculation
        // but if you are coming for the first time then, store that value in memo
        if (n % 2 == 0) {
//            memo[n] = solve(n / 2, memo);
            return solve(n / 2, memo);
        }
        else {
//            memo[n] = 1 + solve(n / 2, memo);
            return 1 + solve(n / 2, memo);
        }
    }
}