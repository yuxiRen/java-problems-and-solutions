//divide the array into two sbuarrays, the left one is sorted, the right one is unsorted. 
//every time find the smallest element of the unsorted array, put it on the last position of the sorted array
//repeating this process until the unsorted array is empty.
//Time: O(N^2)
//Space: O(1)

public class SelectionSort {
  public int[] solve(int[] array) {
    if (array == null || array.length <= 1) {
      return array;
    }
    for (int i = 0; i < array.length - 1; i++) {
      int minPosition = i;
      //find the minimum element in the subarray of (i, array.length - 1)
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[minPosition]) {
          minPosition = array[j];
          minPosition = j;
        }
      }
      swap(array, i, minPosition);
    }
    return array;
  }
}
