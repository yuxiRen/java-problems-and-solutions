public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        boolean[] jumpFrom0 = new boolean[nums.length];
        jumpFrom0[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (jumpFrom0[j] && j + nums[j] >= i) {
                    jumpFrom0[i] = true;
                    break;
                }
            }
        }
        return jumpFrom0[jumpFrom0.length - 1];
    }

}
