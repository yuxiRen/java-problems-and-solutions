public class MissingNumber {
    /*method1: set
    time: O(N)
    space: O(N)
     */

    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }
    /*method2: math
    time: O(N)
    space: O(1)
    */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        int curSum = 0;
        for (int i : nums) {
            curSum += i;
        }
        return sum - curSum;
    }
    /*method3: bit
    time: O(N)
    space: O(1)
    * */
    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i <= nums.length; i++) {
            xor ^= i;
        }
        for (int n : nums) {
            xor ^= n;
        }
        return xor;
    }
}
