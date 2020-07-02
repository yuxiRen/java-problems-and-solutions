public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int left = 0;
        while (left < nums.length - 2) {
            int i = left + 1;
            int j = nums.length - 1;
            int tmp = 0 - nums[left];
            while (i < j) {
                int sum = nums[i] + nums[j];
                if (sum == tmp) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[left]);
                    triplet.add(nums[i++]);
                    triplet.add(nums[j--]);
                    res.add(triplet);
                    //对于相同的就只取一个
                    while (i < j && nums[i] == nums[i - 1]) {
                        i++;
                    }
                    //只需要对于i去重，j自然也就去重了

                } else if (sum < tmp) {
                    i++;
                } else {
                    j--;
                }
            }
            left++;
            while (left < nums.length - 1 && nums[left] == nums[left - 1]) {
                left++;
            }
        }
        return res;
    }

}
