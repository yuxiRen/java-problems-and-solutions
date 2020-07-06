public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][2];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(
                (p1, p2) -> {
                    int distance1 = p1[0] * p1[0] + p1[1] * p1[1];
                    int distance2 = p2[0] * p2[0] + p2[1] * p2[1];
                    return distance2 - distance1;
                }
        );
        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }
        for (int i = 0; i < K; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

}
