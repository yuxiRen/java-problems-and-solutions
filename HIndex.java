public class HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }

    //H-IndexII
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (citations[mid] < n - mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return citations[left] >= n - left ? n - left : 0;

    }
}
