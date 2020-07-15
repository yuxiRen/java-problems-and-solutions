public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int res = 0;
        //norob at the last home
        int n = nums.length;
        int lastRob = nums[0];
        int lastNoRob = 0;
        for (int i = 1; i < n - 1; i++) {
            int tmplastRob = lastRob;
            int tmplastNoRob = lastNoRob;
            lastRob = tmplastNoRob + nums[i];
            lastNoRob = Math.max(tmplastRob, tmplastNoRob);
        }
        res = Math.max(lastRob, lastNoRob);

        //norob at the first home
        lastRob = nums[1];
        lastNoRob = 0;
        for (int i = 2; i < n; i++) {
            int tmplastRob = lastRob;
            int tmplastNoRob = lastNoRob;
            lastRob = tmplastNoRob + nums[i];
            lastNoRob = Math.max(tmplastRob, tmplastNoRob);
        }
        return Math.max(res, Math.max(lastRob, lastNoRob));
    }
}
