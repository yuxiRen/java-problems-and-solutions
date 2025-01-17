public class SearchInUnknownSizedSortedArr {
    /*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/
//Time: O(logN)
//jump out: 2^1 + 2^2 +...+ 2^(x+1) = 2^(x+2) - 1 = N
//x = logN
//jump in: 2^(x+1) - 2^x = N
//x = logN
public class Solution {
    public int search(Dictionary dict, int target) {
      int left = 0;
      int right = 1;
      while (dict.get(right) != null && dict.get(right) < target) {
        left = right;
        right = 2 * right;
      }
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (dict.get(mid) == null || dict.get(mid) > target) {
          right = mid - 1;
        } else if (dict.get(mid) < target) {
          left = mid + 1;
        } else {
          return mid;
        }
      }
      return -1;
    }
  }
}