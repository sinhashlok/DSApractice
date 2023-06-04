package DSApractice.Greedy.Medium;

public class Container_With_Most_Water_11 {
    public static void main(String[] args) {
        int[] h = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(h));
    }

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int area = 0;

        while (l < r) {
            int minHeight = Math.min(height[l], height[r]);
            area = Math.max(Math.abs(l - r) * minHeight, area);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return area;
    }
}