// https://practice.geeksforgeeks.org/problems/game-of-death-in-a-circle1840/1/?page=1&difficulty[]=0&category[]=Recursion&sortBy=accuracy

package DSApractice.LeetCode.Recursion.Easy;

public class Find_the_Safe_Position {
    public static void main(String[] args) {
        int n = 7, k = 4;

        System.out.println(safePos(n, k));
    }

    static int safePos(int n, int k) {
        // code here
        if (n == 1) {
            return 1;
        }
        else {
            return (safePos(n - 1, k) + k - 1) % n + 1;
        }
    }
}
