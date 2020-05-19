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

    //metohd2: quick select
    public int[] kSmallest(int[] array, int k) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int idx = partition(array, l, r);
            if (idx == k - 1) {
                break;
            } else if (idx < k - 1) {
                l = idx + 1;
            } else {
                r = idx - 1;
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = array[i];
        }
        Arrays.sort(res);
        return res;
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = left + (int)Math.random() * (right - left);
        swap(arr, pivot, left);
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (arr[l] < arr[left]) {
                l++;
            } else if (arr[r] > arr[left]) {
                r--;
            } else {
                swap(arr, l++, r--);
            }
        }
        swap(arr, left, r);
        return r;
    }
}
