public class LongestAscendingSubArray {
    /*
    base case:
        M[0] = 1, when there is only one element in the array
    state:
 	    M[i] represents: from the 0-th element to the i-th element(including),
 	    the length of the longest ascending subarray.
    induction rule
    M[i] = M[i - 1] + 1, if array[i] > array[i - 1]
         = 1, else
    */
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
