public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        if (array == null || array.length == 0) {
          return array;
        }
        int i = 0;
        int k = 0;
        int j = array.length - 1;
        while (k <= j) {
          if (array[k] == 0) {
            //array[i] already checked
            swap(array, i++, k++);
          } else if (array[k] == 2) {
            //didn't check array[k] yet, so k can't move
            swap(array, k, j--);
          } else {
            k++;
          }
        }
        return array;
      }
      private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
}