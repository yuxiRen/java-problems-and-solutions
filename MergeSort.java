public class MergeSort {
    
    public int[] mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        int[] helper = new int[array.length];
        mergeSort(array, 0, array.length - 1, helper);
        return array;
  }
  private void mergeSort(int[] array, int left, int right, int[] helper) {
    if (left >= right) {
      return;
    }
    int mid = left + (right - left) / 2;
    mergeSort(array, left, mid, helper);
    mergeSort(array, mid + 1, right, helper);
    merge(array, left, mid, right, helper);
  }

  private void merge(int[] array, int left, int mid, int right, int[] helper) {
    //the merge operation is based on two sorted arrays
    for (int i = left; i <= right; i++) {
      helper[i] = array[i];
    }
    int leftIdx = left;
    int rightIdx = mid + 1;
    while (leftIdx <= mid && rightIdx <= right) {
      if (helper[leftIdx] < helper[rightIdx]) {
        array[left++] = helper[leftIdx++];
      } else {
        array[left++] = helper[rightIdx++];
      }
    }
    while (leftIdx <= mid) {
      array[left++] = helper[leftIdx++];
    }
  }
  }
  