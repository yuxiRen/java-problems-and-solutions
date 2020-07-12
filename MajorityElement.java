public class MajorityElement {
    //M1. Sorting O(logN)
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //M2. Boyer-Moore Voting Algorithm O(N)
    public int majorityElement(int[] nums) {
        int count = 0;
        int majority = 0;
        for (int n : nums) {
            if (count == 0) {
                majority = n;
            }
            count += n == majority ? 1 : -1;
        }
        return majority;
    }
}
