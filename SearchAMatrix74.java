//method1: convert the 2D array to 1D array and do binary search
//Time: O(N)
public class SearchAMatrix74 {
    public int[] search(int[][] matrix, int target) {
        int[] result = new int[]{-1, -1};
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
          int mid = left + (right - left) / 2;
          int r = mid / col;
          int c = mid % col;
          if (matrix[r][c] == target) {
            result[0] = r;
            result[1] = c;
            return result;
          } else if (matrix[r][c] < target) {
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        }
        return result;
      }
}