public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int norob = 0;
        int rob = 1;
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][rob] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][norob], dp[i - 1][rob]);
            dp[i][rob] = dp[i - 1][norob] + nums[i];
        }
        return Math.max(dp[n - 1][norob], dp[n - 1][rob]);
    }
}

