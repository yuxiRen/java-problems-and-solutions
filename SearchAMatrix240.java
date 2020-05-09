//Time: (M+N)
//search start from right top or bottom left
//so we can go both bigger and smaller
public class SearchAMatrix240 {
    public int[] search(int[][] matrix, int target) {
        int[] result = new int[]{-1,-1};
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
          if (matrix[row][col] == target) {
            result[0] = row;
            result[1] = col;
            return result;
          } else if (matrix[row][col] < target) {
            row++;
          } else {
            col--;
          }
        }
        return result;
      }
}