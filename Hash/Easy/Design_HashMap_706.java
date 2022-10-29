package DSApractice.Hash.Easy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Design_HashMap_706 {

    private List<List<Integer>> list;
    public void MyHashMap() {
        list = new ArrayList<>();
    }

    public void put(int key, int value) {
        remove(key);
        list.add(new ArrayList<>(Arrays.asList(key, value)));
    }

    public int get(int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0) == key) {
                return list.get(i).get(1);
            }
        }

        return -1;
    }

    public void remove(int key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get(0) == key) {
                list.remove(i);
                break;
            }
        }
    }
}