// https://practice.geeksforgeeks.org/problems/armstrong-numbers2727/1?category%5B%5D=Mathematical&category%5B%5D=Mathematical&page=2&query=category%5B%5DMathematicalpage2category%5B%5DMathematical

package DSApractice.LeetCode.Math.Easy;

public class Armstrong_Numbers_GFG {

    static String armstrongNumber(int n){
        // code here
        int i = n, sum = 0;

        while (i != 0) {
            sum += (int)Math.pow(i % 10, 3);
            i /= 10;
        }

        if (sum == n) {
            return "Yes";
        }

        return "No";
    }
}