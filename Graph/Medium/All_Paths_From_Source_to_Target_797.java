package DSApractice.Graph.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class All_Paths_From_Source_to_Target_797 {
    public static void main(String[] args) {
        int[][] g = {
//                {4,3,1},
//                {3,2,4},
//                {3},
//                {4},
//                {}
                {4,3,1},
                {},
                {1},
                {2,1},
                {3,1}
        };

        List<List<Integer>> l = allPathsSourceTarget(g);
        System.out.println(l);
        System.out.println(list);
    }

//    static void allPathsSourceTarget(int[][] graph) {
//        for (int i = 0; i < graph[0].length; i++) {
//            System.out.print(0 + " " + graph[0][i] + " ");
//            print(graph, graph[0][i]);
//        }
//
//    }
//
//    static void print(int[][] g, int pos) {
//        if (g[pos].length == 0) {
//            System.out.println();
//            return;
//        }
//
//        for (int i = 0; i < g[pos].length; i++) {
//            System.out.print(g[pos][i] + " ");
//            print(g, g[pos][i]);
//        }
//    }

    private List<List<Integer>> list;
    private List<Integer> temp;
    private List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        temp = new ArrayList<>();
        list = new ArrayList<>();
        temp.add(0);
        for (int i = 0; i < graph[0].length; i++) {
            temp.add(graph[0][i]);

            if (temp.get(temp.size() - 1) == graph.length - 1) {
                list.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                continue;
            }

            print(graph, graph[0][i]);
            temp.remove(temp.size() - 1);
        }

        return list;
    }

    private void print(int[][] g, int pos) {
        for (int i = 0; i < g[pos].length; i++) {
            temp.add(g[pos][i]);

            if (temp.get(temp.size() - 1) == g.length - 1) {
                list.add(new ArrayList<>(temp));
                temp.remove(temp.size() - 1);
                continue;
            }

            print(g, g[pos][i]);
            temp.remove(temp.size() - 1);
        }
    }
}