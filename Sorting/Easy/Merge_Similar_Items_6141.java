package DSApractice.Sorting.Easy;

import java.util.*;

public class Merge_Similar_Items_6141 {
    public static void main(String[] args) {
//        int[][] items1 = {
//                {1,1},
//                {4,5},
//                {3,8}
//        };
//        int[][] items2 = {
//                {3,1},
//                {1,5}
//        };

        int[][] items1 = {
                {1,3},
                {2,2}
        };
        int[][] items2 = {
                {7,1},
                {2,2},
                {1,4}
        };


        List<List<Integer>> list = mergeSimilarItems(items1, items2);

        for (List<Integer> integers : list) {
            System.out.println(integers.get(0) + " " + integers.get(1));
        }
    }

    static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();

        // first add item1
        for (int[] ints : items1) {
            map.put(ints[0], ints[1]); // map(item, value of that item)
        }

        // for item2
        for (int[] ints : items2) {
            if (map.containsKey(ints[0])) {
                map.put(ints[0], map.getOrDefault(ints[0], ints[1]) + ints[1]);
            } else {
                map.put(ints[0], ints[1]);
            }
        }

        List<Integer> temp = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            temp.add(entry.getKey());
        }
        Collections.sort(temp);

        List<List<Integer>> list = new ArrayList<>();
        for (Integer integer : temp) {
            List<Integer> temp1 = new ArrayList<>();
            temp1.add(integer);
            temp1.add(map.get(integer));

            list.add(temp1);
        }


        return list;
    }

}