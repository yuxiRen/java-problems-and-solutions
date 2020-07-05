public class UglyNumberII {
    //method1. time: O(nlogn)  space: O(n)
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(1);
        Set<Integer> set = new HashSet<>();
        while (n > 1) {
            int cur = minHeap.poll();
            if (set.add(cur * 2)) {
                minHeap.offer(cur * 2);
            }
            if (set.add(cur * 3)) {
                minHeap.offer(cur * 3);
            }
            if (set.add(cur * 5)) {
                minHeap.offer(cur * 5);
            }
            n--;
        }
        return minHeap.peek();
    }
    //method2. time: O(n) space: O(1)
    public int nthUglyNumber(int n) {
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        int[] q = new int[n];
        q[0] = 1;
        for (int i = 1; i < n; i++) {
            int num = Math.min(q[i2] * 2, Math.min(q[i3] * 3, q[i5] * 5));
            if (num == q[i2] * 2) {
                i2++;
            }
            if (num == q[i3] * 3) {
                i3++;
            }
            if (num == q[i5] * 5) {
                i5++;
            }
            q[i] = num;
        }
        return q[n - 1];
    }
}
