// https://practice.geeksforgeeks.org/problems/print-all-possible-strings/1/?page=1&difficulty[]=0&category[]=Recursion&sortBy=accuracy

package DSApractice.LeetCode.Recursion.Easy;

import java.util.ArrayList;

public class Print_all_possible_strings {
    public static void main(String[] args) {
        ArrayList<String> res = spaceString("abc");
        System.out.println(res);
    }

    static ArrayList<String> spaceString(String str) {
        if(str.length() == 1) {
            ArrayList<String> res = new ArrayList<>();
            res.add(str);

            return res;
        }

        ArrayList<String> prevList = spaceString(str.substring(0,str.length()-1));
        ArrayList<String> res = new ArrayList<>();

        char current = str.charAt(str.length() - 1);
        for(String st : prevList) {
            res.add(st + "" + current);
            res.add(st + " " + current);
        }

        return res;
    }
}
