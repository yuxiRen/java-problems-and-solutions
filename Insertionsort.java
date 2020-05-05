public class Insertionsort {
    public static int[] sort(int[] array) {
      if (array == null || array.length <= 1) {
        return array;
      }
      for (int i = 1; i < array.length; i++) {
        int marker = i;
        for (int j = i - 1; j >= 0; j--) {
          if (array[j] > array[marker]) {
            swap(array, marker, j);
            marker = j;
          } else {
            break;
          }
        }
      }
      return array;
    }
}
  
