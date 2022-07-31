// https://practice.geeksforgeeks.org/problems/lucky-numbers2911/1/?page=1&difficulty[]=0&category[]=Recursion&sortBy=accuracy

package DSApractice.LeetCode.Recursion.Easy;

public class Lucky_Numbers {
    static int counter = 2;
    public static void main(String[] args) {
        int x = 74;
        if(isLucky(x)) {
            System.out.println(x + " is a lucky no.");
        } else {
            System.out.println(x + " is not a lucky no.");
        }
    }

    static boolean isLucky(int n) {
        if(counter > n) {
            return true;
        }
        if(n%counter == 0) {
            return false;
        }

        /* calculate next position of input no. Variable "next_position" is just for
        readability of the program we can remove it and update in "n" only */
        int next_position = n - (n/counter);

        counter++;
        return isLucky(next_position);
    }
}
