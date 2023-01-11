package DSApractice.Graph.Medium;

import GFG.Graph.DG;

import java.util.ArrayList;
import java.util.List;

public class Number_of_Islands_200 {

    public int numIslands(char[][] grid) {
        // we will use DFS
        // we will just mark the visited to '1' to '0' -> to mark they are visited

        int count = 0;  // will keep track of number of islands

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    DFS(grid, i, j);
                    ++count;
                }
            }
        }

        return cout;
    }

    private void DFS(char[][] grid, int i, int j) {
        // if out of bound or not element is not '1'
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';   // mark already visited as '0'
        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);
        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
    }
}