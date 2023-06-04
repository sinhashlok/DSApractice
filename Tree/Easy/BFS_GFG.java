package DSApractice.Tree.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_GFG {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V + 1];

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            res.add(u);

            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }

        return res;
    }
}