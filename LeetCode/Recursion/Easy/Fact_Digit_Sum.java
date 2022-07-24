// https://practice.geeksforgeeks.org/problems/fact-digit-sum4125/1/?page=1&difficulty[]=0&category[]=Recursion&sortBy=accuracy

package DSApractice.LeetCode.Recursion.Easy;

import java.util.ArrayList;
import java.util.Collections;

public class Fact_Digit_Sum {
    public static void main(String[] args) {
        int n = 40321;

        ArrayList<Integer> res = FactDigit(n);
        System.out.println(res);
    }

    static ArrayList<Integer> FactDigit(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] arr = {1,1,2,6,24,120,720,5040,40320,362880};

        int i = 9;

        while (n > 0) {
            while (n >= arr[i]) {
                res.add(i);
                n -= arr[i];
            }

            i --;
        }

        Collections.sort(res);
        return res;
    }
}
