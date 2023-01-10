package DSApractice.Graph.Easy;

public class Find_Center_of_Star_Graph_1791 {

    public int findCenter(int[][] edges) {
        int a = edges[0][0];
        int b = edges[0][1];
        int c = edges[1][0];
        int d = edges[1][1];

        if (Math.min(a, b) == Math.min(c, d)) {
            return Math.min(a, b);
        } else if (Math.min(a, b) == a) {
            return b;
        }

        return a;
    }
}