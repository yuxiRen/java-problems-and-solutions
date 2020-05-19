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

    //method2: Quick Select
    /*Time:
    worst: O(N^2)
    average:O(N) (N + N/2 + N/4 +...+ find k) = O(N)
    Space: O(1)*/

    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int idx = partition(nums, left, right);
            if (idx == k - 1) {
                return nums[idx];
            } else if (idx < k - 1) {
                left = idx + 1;
            } else {
                right = idx - 1;
            }
        }
        return -1;
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = left + (right - left) * (int)Math.random();
        swap(arr, pivot, left);
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (arr[l] > arr[left]) {
                l++;
            } else if (arr[r] < arr[left]) {
                r--;
            } else {
                swap(arr, l++, r--);
            }
        }
        swap(arr, left, r);
        return r;
    }
}
