package DSApractice.DP.Medium;

import java.util.List;

public class Triangle_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();

        // here we go from bottom up - last level to top level
        // do reverse order
        for(int i = len - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++){
                int min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                // min - gives us the smaller one to which it was going to be added
                triangle.get(i).set(j, triangle.get(i).get(j) + min);
            }
        }

        return triangle.get(0).get(0);
    }


    public int minimumTotalMyApproach(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    int up = triangle.get(i - 1).get(j);
                    int curr = triangle.get(i).get(j);
                    triangle.get(i).set(j, curr + up);
                } else if (j == triangle.get(i).size() - 1) {
                    int up = triangle.get(i - 1).get(j - 1);
                    int curr = triangle.get(i).get(j);
                    triangle.get(i).set(j, curr + up);
                } else {
                    int upL = triangle.get(i - 1).get(j - 1);
                    int upR = triangle.get(i - 1).get(j);
                    int curr = triangle.get(i).get(j);
                    curr += Math.min(upL, upR);
                    triangle.get(i).set(j, curr);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int m = triangle.size() - 1;
        for (int j = 0; j < triangle.get(m).size(); j++) {
            min = Math.min(min, triangle.get(m).get(j));
        }

        return min;
    }
}