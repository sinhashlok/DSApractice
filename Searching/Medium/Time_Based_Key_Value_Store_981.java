package DSApractice.Searching.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Time_Based_Key_Value_Store_981 {
//    public static void main(String[] args) {
//        TimeMap();
//        set("love","high",10);
//        set("love","low",20);
//        System.out.println(get("love",5));
//        System.out.println(get("love",10));
//        System.out.println(get("love",15));
//        System.out.println(get("love",20));
//        System.out.println(get("love",25));
//    }


        // My Approach - V.Very Slow
    ArrayList<Integer> time;
    // time - stores the time at which each input was taken, and we track it to the key and value pair
    // using the index of the ArrayList

    HashMap<Integer, HashMap<String, String>> map;
    // [index(of timestamp in time), HashMap{key, value}]

    public void TimeMap() {
        time = new ArrayList<>();
        map = new HashMap<Integer, HashMap<String, String>>();
    }

    public void set(String key, String value, int timestamp) {
        time.add(timestamp);

        HashMap<String, String> input = new HashMap<>();
        input.put(key, value);

        map.put(time.size() - 1, new HashMap<>(input));
    }

    public String get(String key, int timestamp) {
        // Binary Search - gives the rightmost occurrence timestamp
        int l = 0, r = time.size() - 1, m = 0;
        while (l < r) {
            m = l + (r - l) / 2;

            if (time.get(m) > timestamp) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        while (l != -1) {
            if ((time.get(l) <= timestamp) && (map.get(l).containsKey(key))) {
                return (String) map.get(l).get(key);
            }

            l--;
        }

        return "";
    }
}