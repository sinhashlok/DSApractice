package DSApractice.Strings.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Remove_Letter_To_Equalize_Frequency_6212 {
    public static void main(String[] args) {
        System.out.println(equalFrequency("aca"));
    }

    static boolean equalFrequency(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (list.size() == 0) {
                list.add(e.getValue());
            } else if (!list.contains(e.getValue())) {
                list.add(e.getValue());
            }
        }

        if (list.size() > 2) {
            return false;
        } else if (list.size() == 1) {
            if (list.get(0) == 1) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
}