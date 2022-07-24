// https://practice.geeksforgeeks.org/problems/finding-profession3834/1/?page=1&difficulty[]=0&category[]=Recursion&sortBy=accuracy


/*
    The result is based on count of 1’s in binary representation of position minus one.
    If count of 1’s is even then result is Engineer, else then Doctor.
*/

package DSApractice.LeetCode.Recursion.Easy;

import java.util.ArrayList;

public class Finding_Profession {
//    static char ch;
    public static void main(String[] args) {
        System.out.println(findProffesion(4, 2));
    }

    static char findProffesion(int level, int pos) {
        // Count set bits in 'pos-1'
        int c = countSetBits(pos-1);

        // If set bit count is odd, then doctor, else engineer
        return (c%2 !=0)? 'd' : 'e';
    }

    static int countSetBits(int n) {
        int count = 0;
        while (n!=0) {
            n &= (n-1) ;
            count++;
        }
        return count;
    }
}
