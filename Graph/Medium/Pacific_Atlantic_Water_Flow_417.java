package DSApractice.Graph.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pacific_Atlantic_Water_Flow_417 {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            DFS(heights, pacific, i, 0, m, n);
            DFS(heights, atlantic, i, n - 1, m, n);
        }

        for (int j = 0; j < n; j++) {
            DFS(heights, pacific, 0, j, m, n);
            DFS(heights, atlantic, m - 1, j, m, n);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void DFS(int[][] heights, boolean[][] visited, int i, int j, int m, int n) {
        visited[i][j] = true;

        if (i > 0 && !visited[i - 1][j] && heights[i - 1][j] >= heights[i][j]) {
            DFS(heights, visited, i - 1, j, m, n);
        }
        if (i < m - 1 && !visited[i + 1][j] && heights[i + 1][j] >= heights[i][j]) {
            DFS(heights, visited, i + 1, j, m, n);
        }
        if (j > 0 && !visited[i][j - 1] && heights[i][j - 1] >= heights[i][j]) {
            DFS(heights, visited, i, j - 1, m, n);
        }
        if (j < n - 1 && !visited[i][j + 1] && heights[i][j + 1] >= heights[i][j]) {
            DFS(heights, visited, i, j + 1, m, n);
        }
    }
}