package DSApractice.Tree.Medium;

import java.util.ArrayList;
import java.util.List;

public class Minimum_Number_of_Vertices_to_Reach_All_Nodes_1557 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] arr = new boolean[n];
        for (int i = 0; i < edges.size(); i++) {
            arr[edges.get(i).get(1)] = true;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}