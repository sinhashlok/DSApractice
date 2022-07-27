// https://practice.geeksforgeeks.org/problems/factorial5739/1?category%5B%5D=Mathematical&category%5B%5D=Mathematical&page=3&query=category%5B%5DMathematicalpage3category%5B%5DMathematical

package DSApractice.LeetCode.Math.Easy;

public class Factorial_GFG {

    static long factorial(int N){
        if (N == 0) {
            return 1;
        }

        // code here
        if (N == 1) {
            return 1;
        }

        return (long)(factorial(N - 1) * N);
    }
}