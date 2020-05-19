public class KthLargestinArray {
    //method1: Heap
    //Time: O(Nlogk)
    //Space: O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(n);
            } else {
                if (n > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(n);
                }
            }
        }
        return minHeap.peek();
    }
}
