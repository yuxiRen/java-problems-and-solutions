public class Insertionsort {
    public static int[] sort(int[] array) {
      if (array == null || array.length <= 1) {
        return array;
      }
      for (int i = 1; i < array.length; i++) {
        int marker = i;
        for (int j = i - 1; j >= 0; j--) {
          if (array[j] > array[marker]) {
            System.out.print(array[marker]);
            System.out.print(array[j]+" ");
            swap(array, marker, j);
            marker = j;
            printArray(array);
          } else {
            break;
          }
        }
      }
      return array;
    }
  
    private static void swap(int[] arr, int i, int j) {
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
    }
    
    public static void printArray(int[] nums) {
      for (int num : nums) {
        System.out.print(num);
        System.out.print(' ');
      }
      System.out.println();
    }

    public static void main(String[] args) {
        Insertionsort so = new Insertionsort();
        int[] arr = new int[]{4,2,-3,6,1};
        so.sort(arr);
        printArray(arr);
    }
  }
  