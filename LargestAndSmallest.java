public class LargestAndSmallest {
    public int[] largestAndSmallest(int[] array) {
        if (array.length == 1) {
            return new int[]{array[0],array[0]};
        }
        int left = 0;
        int right = array.length - 1;
        int[] res = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        while (left < right) {
            if (array[left] > array[right]) {
                swap(array, left, right);
            }
            left++;
            right--;
        }
        for (int i = 0; i < left; i++) {
            res[1] = Math.min(array[i], res[1]);
        }
        for (int i = array.length - 1; i > right; i--) {
            res[0] = Math.max(array[i], res[0]);
        }
        if (left == right) {
            res[0] = Math.max(array[left], res[0]);
            res[1] = Math.min(array[left], res[1]);
        }
        return res;
    }
}
