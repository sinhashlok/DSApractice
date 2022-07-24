// https://practice.geeksforgeeks.org/problems/recamans-sequence4856/1/?page=1&difficulty[]=0&category[]=Recursion&sortBy=accuracy

package DSApractice.LeetCode.Recursion.Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Recamans_sequence_GFG {
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        int n = 17;

        ArrayList<Integer> list = recamanSequence(n);

        for (Integer l : list) {
            System.out.print(l + " ");
        }
    }

    static ArrayList<Integer> recamanSequence(int n){
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        sequence(n, 0, list, set);

        return list;
    }

    static void sequence(int n, int i, ArrayList<Integer> list, Set<Integer> set) {
        if (n == i) {
            return;
        }

        if (i == 0) {
            list.add(i);
        } else if (i < list.get(i - 1) && !set.contains(list.get(i-1) - i)) {
            list.add(list.get(i - 1) - i);
        } else {
            list.add(list.get(i-1) + i);
        }

        set.add(list.get(i));

        sequence(n, i + 1, list, set);
    }
}
