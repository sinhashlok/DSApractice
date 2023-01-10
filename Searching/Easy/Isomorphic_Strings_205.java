// https://leetcode.com/problems/isomorphic-strings/

package DSApractice.Searching.Easy;

import java.util.Arrays;

public class Isomorphic_Strings_205 {

    public boolean isIsomorphic(String s, String t) {
        int[] mapStoT = new int[256];
        int[] mapTtoS = new int[256];

        Arrays.fill(mapStoT, -1);
        Arrays.fill(mapTtoS, -1);

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // No mapping exists in either of the dictionaries
            if (mapStoT[c1] == -1 && mapTtoS[c2] == -1) {
                mapStoT[c1] = c2;
                mapTtoS[c2] = c1;
            }

            // Ether mapping doesn't exist in one of the dictionaries or Mapping exists, and
            // it doesn't match in either of the dictionaries or both
            if (mapStoT[c1] != c2 && mapTtoS[c2] != c1) {
                return false;
            }
        }

        return true;
    }
}