package DSApractice.Graph.Easy;

import java.util.Arrays;

public class Flood_Fill_733 {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // if source element already matches the color, no need to do any food fill
        if (image[sr][sc] == color) {
            return image;
        }

        // we will use DFS approach
        // we do NOT need a boolean array to keep track of visited elements (see helper method)
        // we make int x = image[sr][sc] => this makes sure that we only visited same (color) elements
        helper(image[sr][sc], image, sr, sc, color);
        return image;
    }

    private void helper(int x, int[][] img, int sr, int sc, int color) {
        // as we update the source element, now source is not same as x,
        // so we do not again traverse this element
        img[sr][sc] = color;

        // check all four direction
        // UP
        if ((sr != 0) && (img[sr - 1][sc] == x)) {
            helper(x, img, sr - 1, sc, color);
        }
        // LEFT
        if ((sc != 0) && (img[sr][sc - 1] == x)) {
            helper(x, img, sr, sc - 1, color);
        }
        // DOWN
        if ((sr != img.length - 1) && (img[sr + 1][sc] == x) ) {
            helper(x, img, sr + 1, sc, color);
        }
        // RIGHT
        if ((sc != img[0].length - 1) && (img[sr][sc + 1] == x)) {
            helper(x, img, sr, sc + 1, color);
        }
    }
}