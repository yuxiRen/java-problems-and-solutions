public class MaximumSubarray {
    public int largestSum(int[] array) {
        int prevSum = array[0];
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            if (prevSum > 0) {
                prevSum += array[i];
            } else {
                prevSum = array[i];
            }
            res = Math.max(prevSum, res);
        }
        return res;
    }
}
