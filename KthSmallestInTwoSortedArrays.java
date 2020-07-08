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
    //method2 time: O(log(a+b))
    public int kth(int[] a, int[] b, int k) {
        return kth(a, 0, b, 0, k);
    }
    private int kth(int[] a, int aStart, int[] b, int bStart, int k) {
        if (aStart >= a.length) {
            return b[bStart + k -1];
        }
        if (bStart >= b.length) {
            return a[aStart + k -1];
        }
        if (k == 1) {
            return a[aStart] < b[bStart] ? a[aStart] : b[bStart];
        }
        int aMid = aStart + k / 2 - 1;
        int bMid = bStart + k / 2 - 1;
        if (aMid >= a.length || (bMid < b.length && a[aMid] > b[bMid])) {
            return kth(a, aStart, b, bMid + 1, k - k / 2);
        } else {
            return kth(a, aMid + 1, b, bStart, k - k / 2);
        }
    }
}

