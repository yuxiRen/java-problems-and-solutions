public class MissingNumber {
    /*method1: set
    time: O(N)
    space: O(N)
     */
     */
    */
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
}
