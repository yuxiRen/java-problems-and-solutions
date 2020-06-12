public class LongestAscendingSubArray {
    public int longest(int[] array) {
        if (array.length <= 1) {
            return array.length;
        }
        int res = 1;
        int cur = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                cur++;
                res = Math.max(res, cur);
            } else {
                cur = 1;
            }
        }
        return res;
    }
}
