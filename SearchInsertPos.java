//different from leetcode problem, there are multiple elements with value same as target
//we should insert the target before the first existing element.
public class SearchInsertPos {
    public int searchInsert(int[] input, int target) {
        if (input == null || input.length == 0) {
          return 0;
        }
        int left = 0;
        int right = input.length - 1;
        while (left < right - 1) {
          int mid = left + (right - left) / 2;
          if (input[mid] >= target) {
            //cause the right pointer may don't move
            //we need break the loop before left==right, to avoid infinite loop
            right = mid;
          } else {
            left = mid + 1;
          }
        }
        if (input[left] >= target) {
          return left;
        } else if (input[right] >= target) {
          return right;
        } else {
          //for the case all elements are smaller than target
          return input.length;
        }
      }
}