public class FindKClosestEle {
    //Method1:
    //Time: O(logN)
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

    //Method2:
    //Time: O(N)
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

}