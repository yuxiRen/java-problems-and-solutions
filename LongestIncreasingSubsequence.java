public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] helper = new int[nums.length];
        helper[0] = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > helper[len - 1]) {
                helper[len] = nums[i];
                len++;
            } else {
                int smallestLargerIdx = smallestLarger(helper, i - 1, nums[i]);
                helper[smallestLargerIdx] = nums[i];
            }

        }

        return len;
    }

    private int smallestLarger(int[] arr, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
