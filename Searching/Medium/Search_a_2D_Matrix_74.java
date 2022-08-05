package DSApractice.Searching.Medium;

public class Search_a_2D_Matrix_74 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60},
                {65,78,86,101}
        };

        System.out.println(searchMatrix(arr, 34));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        if ((target < matrix[0][0]) || (target > matrix[matrix.length - 1][matrix[0].length - 1])) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        int end = (rows * cols) - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // mid/col, works because, mid is indirectly for end, where end = row * col
            // so when divide we do get back row as mid / col
            // as for mid % col, straight forward
            if (matrix[mid / cols][mid % cols] == target) {
                return true;
            }

            if (matrix[mid / cols][mid % cols] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}