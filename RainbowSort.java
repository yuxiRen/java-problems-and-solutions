public class RainbowSort {
  3color:
  public int[] rainbowSort(int[] array) {
    if (array == null || array.length == 0) {
      return array;
    }
    int i = 0;
    int k = 0;
    int j = array.length - 1;
    while (k <= j) {
      if (array[k] == 0) {
        // array[i] already checked
        swap(array, i++, k++);
      } else if (array[k] == 2) {
        // didn't check array[k] yet, so k can't move
        swap(array, k, j--);
      } else {
        k++;
      }
    }
    return array;
  }



  // followup: 4colors
  //bucket sort
  public int[] rainbowSortII(int[] array) {
    int[] count = new int[4];
    for (int i = 0; i < array.length; i++) {
      count[array[i]]++;
    }
    int index = 0;
    for (int i = 0; i < count.length; i++) {
      while (count[i] > 0) {
        array[index++] = i;
        count[i]--;
      }
    }
    return array;
  }

  //followup: Given an array of balls with k different colors denoted by numbers 1- k, 
  //sort the balls.

  //method1: quick sort
  //Time:O(NlogK)
  public int[] rainbowSortIII(int[] array, int k) {
    sort(array, 1, k, 0, array.length - 1);
    return array;
  }
  private void sort(int[] array, int colorFrom, int colorTo, int left, int right) {
    if (left >= right || colorFrom == colorTo) {
      return;
    }
    int l = left;
    int r = right;
    int mid = (colorTo + colorFrom) / 2;
    while (l <= r) {
      if (array[l] <= mid) {
        l++;
      } else if (array[r] > mid) {
        r--;
      } else {
        swap(array, l++, r--);
      }
    }
    sort(array, colorFrom, mid, left , l-1);
    sort(array, mid + 1, colorTo, r+1, right);
  }

  //method2: convert thr problem to sorting two colors for k/2 times.
  //Time: O(kN)
  public int[] rainbowSortIII(int[] array, int k) {
    int left = 0;
    int right = array.length - 1;
    for (int i = 1; i <= k / 2; i++) {
      int leftColor = i;
      int rightColor = k + 1 - i;
      int idx = left;
      while (idx <= right) {
        if (array[idx] == leftColor) {
          swap(array, left++, idx);
        } else if (array[idx] == rightColor) {
          swap(array, right--, idx--);
        }
        idx++;
      }
    }
    return array;
  }
}
