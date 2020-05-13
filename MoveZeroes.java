public class MoveZeroes {
    //if don't need to maintain the original array
    public int[] moveZero(int[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
          if (array[i] != 0) {
            i++;
          } else if (array[j] == 0) {
            j--;
          } else {
            swap(array, i++, j--);
          }
        }
        return array;
      }
}