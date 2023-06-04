package DSApractice.Graph.Medium;

public class Count_Sub_Islands_1905 {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int result = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1 && DFS(grid1, grid2, i, j)) {
                    result++;
                }
            }
        }

        return result;
    }
    private boolean DFS(int[][] grid1, int[][] grid2, int i, int j) {
        boolean result = true;

        if (i >= 0 && i < grid2.length && j >= 0 && j < grid2[0].length && grid2[i][j] == 1) {
            if (grid2[i][j] != grid1[i][j]) {
                result = false;
            }

            grid2[i][j] = -1; // Mark Visited
            boolean left = DFS(grid1, grid2, i, j -1);
            boolean right = DFS(grid1, grid2, i, j +1);
            boolean top = DFS(grid1, grid2, i-1, j);
            boolean bottom = DFS(grid1, grid2, i+1, j);
            if (!left || !right || !top || !bottom) {
                return false;
            }
        }

        return result;
    }
}