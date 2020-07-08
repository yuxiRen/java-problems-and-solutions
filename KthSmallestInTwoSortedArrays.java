public class KthSmallestInTwoSortedArrays {
    //method1 time: O(k)
    public int kth(int[] a, int[] b, int k) {
        int i = 0;
        int j = 0;
        while (k > 1) {
            if ((i < a.length && j < b.length && a[i] > b[j]) || i == a.length) {
                j++;
            } else {
                i++;
            }
            k--;
        }
        if (i == a.length) {
            return b[j];
        } else if (j == b.length) {
            return a[i];
        } else {
            return a[i] < b[j] ? a[i] : b[j];
        }
    }
}

