//Time: O(N)
//Space: O(1)

public class FirstOccurrence {
    public int firstOccur(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        //after left+1, right-1, we should notice ArrayIndexOutOfBoundsException 
        if (left < array.length && right >= 0 && array[right] == target) {
            return right;
        }
        return -1;
    }
}