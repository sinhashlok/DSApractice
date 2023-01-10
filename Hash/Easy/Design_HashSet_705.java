package DSApractice.Hash.Easy;

import java.util.ArrayList;
import java.util.List;

public class Design_HashSet_705 {

        // poor approach
    private List<Integer> set;
    public void MyHashSet() {
        set = new ArrayList<>();
    }

    public void add(int key) {
        if (!set.contains(key)) {
            set.add(key);
        }
    }

    public void remove(int key) {
        set.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        return set.contains(key);
    }
}