public class SelectionSort {
  public int[] solve(int[] array) {
    if (array == null || array.length <= 1) {
      return array;
    }
    for (int i = 0; i < array.length - 1; i++) {
      int min = array[i];
      int minPosition = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < min) {
          min = array[j];
          minPosition = j;
        }
      }
      swap(array, i, minPosition);
    }
    return array;
  }

  private static void swap(int[] arr, int i, int j) {
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
    }
}
