//divide the array into two sbuarrays, the left one is sorted, the right one is unsorted. 
//everytime taking the first item of the unsorted array as a marker, and put it at the correct position of the sorted array.
//how to find the correct position? swap the marker with the bigger item.
//repeating this process until the unsorted array is empty
//Time: O(N^2)
//Space: O(1)
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
  
