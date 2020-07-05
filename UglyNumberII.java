public class UglyNumberII {
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
}
