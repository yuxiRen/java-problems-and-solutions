public class FourSum {
    //method1. four pointers
    //time: O(N^3) space: O(1)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                int curTarget = target - nums[i] - nums[j];
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == curTarget) {
                        List<Integer> cur = new ArrayList<>();
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        cur.add(nums[left++]);
                        cur.add(nums[right--]);
                        res.add(cur);
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    } else if (sum < curTarget) {
                        left++;
                    } else {
                        right--;
                    }

                }
            }
        }
        return res;
    }

    //method2.
}
