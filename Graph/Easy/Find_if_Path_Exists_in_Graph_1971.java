package DSApractice.Graph.Easy;

import java.util.ArrayList;

public class Find_if_Path_Exists_in_Graph_1971 {

    private boolean flag = false;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }

        // constructing a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if (adj.get(source).contains(destination)) {  // direct connection exists
            return true;
        }

        boolean[] visited = new boolean[n];

        DFS(adj, source, destination, visited);
        return flag;
    }

    private void DFS(ArrayList<ArrayList<Integer>> adj, int s, int d, boolean[] visited) {
        if(!visited[s] && !flag){
            if(s == d){
                flag = true;
                return;
            }

            visited[s] = true;
            for(int u : adj.get(s)){
                DFS(adj, u, d, visited);
            }
        }
    }
}