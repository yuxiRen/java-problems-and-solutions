public class FindKClosestEle {
    // Method1:
    // Time: O(logN)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x <= arr[mid]) {
                right = mid;
            } else {
                if (x - arr[mid] > arr[mid + k] - x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            result.add(arr[left++]);
        }
        return result;
    }

    // Method2:
    /*
     * 用Binary Search找到一个长度为k的区间，并且区间x正好是区间的正中央。（如何表达区间？区间的leftBound） 通过移动left,
     * right来移动A[mid]~A[mid] + k区间，最后达到x==A[mid]
     * 
     * case 1: x < A[mid]，此时区间需要左移 so right = mid
     * -------x----A[mid]-----------------A[mid + k]----------
     * 
     * 当x > A[mid]时有多种情况 case 2: x - A[mid] < A[mid + k] - x, 区间需要左移 so right = mid
     * 注意此时不怕x在[left,right]之外，因为新的[left,right]形成的[mid,mid + k]是有可能含有x的
     * -------A[mid]----x-----------------A[mid + k]----------
     * 
     * case 3: x - A[mid] > A[mid + k] - x, 区间需要右移,并且mid肯定不在其中了，so left = mid+1
     * -------A[mid]------------------x---A[mid + k]----------
     * 
     * case 4: x - A[mid] > A[mid + k] - x, 区间需要右移,并且mid肯定不在其中了，so left = mid+1
     * -------A[mid]---------------------A[mid + k]----x------
     */

    // Time: O(N)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length - k; i++) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                right--;
            } else {
                left++;
            }
        }
        while (left <= right) {
            result.add(arr[left++]);
        }
        return result;
    }

    // Method3:
    // Time: O(logN)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }

        for (int i = 0; i < k; i++) {
            if (right >= arr.length || (left >= 0 && Math.abs(arr[left] - x) <= Math.abs(arr[right] - x))) {
                result.add(0, arr[left--]);
            } else {
                result.add(arr[right++]);
            }
        }

        return result;
    }
}