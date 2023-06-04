package DSApractice.Greedy.Medium;

public class Jump_Game_55 {

    public boolean canJump(int[] nums) {
        int dis = 0;    // tracks max distance that we can jump

        for (int i = 0; i <= dis; i++) {
            dis = Math.max(dis, i + nums[i]);

            if (dis >= nums.length-1) {
                return true;
            }
        }

        return false;
    }
}