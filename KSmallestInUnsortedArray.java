import java.util.*;
public class KSmallestInUnsortedArray {
    //method1. maxHeap
    //Time: O(Nlogk)
    //Space: O(k)
    public static int[] kSmallest(int[] array, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y)->y-x);
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else if (array[i] > maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = maxHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        KSmallestInUnsortedArray so = new KSmallestInUnsortedArray();
        int[] arr = new int[]{3, 4, 1, 2, 5};
        int[] res = kSmallest(arr, 3);
        for (int r : res) {
            System.out.print(r+", ");
        }
    }
}
