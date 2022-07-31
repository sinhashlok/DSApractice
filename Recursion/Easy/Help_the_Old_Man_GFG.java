// https://practice.geeksforgeeks.org/problems/help-the-old-man3848/1/?page=1&difficulty[]=0&category[]=Recursion&sortBy=accuracy#

package DSApractice.LeetCode.Recursion.Easy;

import java.util.ArrayList;
import java.util.List;

public class Help_the_Old_Man_GFG {
    static List<Integer> res;
    static int count;

    public static void main(String[] args) {
        int N = 3, n = 2;
        List<Integer> ans = new ArrayList<>();
        ans = shiftPile(N, n);
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }

    static List<Integer> shiftPile(int N, int n){
        // code here
        res = new ArrayList<>();
        count = 0;
        movePile(N, n, 1, 3, 2);
        return res;
    }

    static void movePile(int N, int n, int fb, int tb, int wb) {
        if (N >= 1 && count < n) {
            movePile(N-1, n, fb, wb, tb);
            movePlate(n, fb, tb);
            if (res.size() > 0)
                return;

            movePile(N-1, n, wb, tb, fb);
        }
    }

    static void movePlate(int n, int fb, int tb){
        count += 1;
        if(count == n){
            res.add(fb);
            res.add(tb);
        }
    }
}
