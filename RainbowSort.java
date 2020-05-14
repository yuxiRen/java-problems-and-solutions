public class RainbowSort {

  public static int[] rainbow(int[] array, int k) {
    if (array == null || array.length < 2) {
        return array;
    }
    int left = 0;
    int right = array.length - 1;
    for (int round = 1; round <= k / 2; round++) {
        // since leftColor + rightColor == k + 1
        int leftColor = round;
        int rightColor = k + 1 - round;
        for (int i : array) {
          System.out.print(i+", ");
        }
        System.out.println();
        for (int i = left; i <= right; i++) {
            if (array[i] == leftColor) {
                swap(array, i, left);
                left++;
            } else if (array[i] == rightColor) {
                swap(array, i, right);
                i--;
                right--;
            }
        }
    }
    return array;
  }
    private static void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }
    public static void main(String[] args) {
      int[] arr = new int[]{3, 1, 5, 5, 1, 4, 2};
      RainbowSort.rainbow(arr, 5);
    }
}
  // 3color:
  // public int[] rainbowSort(int[] array) {
  //   if (array == null || array.length == 0) {
  //     return array;
  //   }
  //   int i = 0;
  //   int k = 0;
  //   int j = array.length - 1;
  //   while (k <= j) {
  //     if (array[k] == 0) {
  //       // array[i] already checked
  //       swap(array, i++, k++);
  //     } else if (array[k] == 2) {
  //       // didn't check array[k] yet, so k can't move
  //       swap(array, k, j--);
  //     } else {
  //       k++;
  //     }
  //   }
  //   return array;
  // }



  // // followup: 4colors
  // //bucket sort
  // public int[] rainbowSortII(int[] array) {
  //   int[] count = new int[4];
  //   for (int i = 0; i < array.length; i++) {
  //     count[array[i]]++;
  //   }
  //   int index = 0;
  //   for (int i = 0; i < count.length; i++) {
  //     while (count[i] > 0) {
  //       array[index++] = i;
  //       count[i]--;
  //     }
  //   }
  //   return array;
  // }

  // //followup: Given an array of balls with k different colors denoted by numbers 1- k, 
  // //sort the balls.
  // public int[] rainbowSortIII(int[] array, int k) {
  //   sort(array, 1, k, 0, array.length - 1);
  //   return array;
  // }
  // private void sort(int[] array, int colorFrom, int colorTo, int left, int right) {
  //   if (left >= right || colorFrom == colorTo) {
  //     return;
  //   }
  //   int l = left;
  //   int r = right;
  //   int mid = (colorTo + colorFrom) / 2;
  //   while (l <= r) {
  //     if (array[l] <= mid) {
  //       l++;
  //     } else if (array[r] > mid) {
  //       r--;
  //     } else {
  //       swap(array, l++, r--);
  //     }
  //   }
  //   sort(array, colorFrom, mid, left , l-1);
  //   sort(array, mid + 1, colorTo, r+1, right);
  // }
  