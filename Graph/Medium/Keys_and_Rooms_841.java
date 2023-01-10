package DSApractice.Graph.Medium;

import java.util.List;

public class Keys_and_Rooms_841 {

    private boolean[] arr;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        arr = new boolean[rooms.size()];
        arr[0] = true;

        helper(rooms, 0);

        for (boolean b : arr) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    private void helper(List<List<Integer>> rooms, int i) {
        if (rooms.get(i).size() != 0) {
            for (int j = 0; j < rooms.get(i).size(); j++) {
                if (rooms.get(i).get(j) == i || arr[rooms.get(i).get(j)]) {
                    continue;
                }
                arr[rooms.get(i).get(j)] = true;
                helper(rooms, rooms.get(i).get(j));
            }
        }
    }
}