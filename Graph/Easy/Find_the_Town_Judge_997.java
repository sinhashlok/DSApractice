package DSApractice.Graph.Easy;

import java.util.ArrayList;
import java.util.LinkedList;

public class Find_the_Town_Judge_997 {

    public int findJudge(int n, int[][] trust) {
        int[] trusted = new int[n + 1];
        for(int[] person : trust) {
            trusted[person[0]]--;
            trusted[person[1]]++;
        }

        for(int i = 1; i < trusted.length; i++) {
            if(trusted[i] == n-1) {
                return i;
            }
        }
        return -1;
    }
}