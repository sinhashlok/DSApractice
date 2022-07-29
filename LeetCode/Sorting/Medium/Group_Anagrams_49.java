// https://leetcode.com/problems/group-anagrams/

package DSApractice.LeetCode.Sorting.Medium;

import java.util.*;

public class Group_Anagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        // if strs is empty
        if (strs == null || strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs)
        {
            // sort the string as character
            char[] ca = s.toCharArray();
            Arrays.sort(ca);

            // converted the sorted string, which is in char form to string
            String keyStr = String.valueOf(ca);

            // if sorted string is already not there means new type of Anagram -> make new list and add to it
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());

            // else the sorted string is there -> find the sorted ones #value - which is the list, and add it to the list
            map.get(keyStr).add(s);
        }
        // make an arraylist of value of map
        return new ArrayList<>(map.values());
    }
}