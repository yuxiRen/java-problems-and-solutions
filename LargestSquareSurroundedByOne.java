//Determine the largest square surrounded by 1s in a binary matrix
// (a binary matrix only contains 0 and 1),
// return the length of the largest square.
public class LargestSquareSurroundedByOne {
    public int largestSquareSurroundedByOne(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 0 || col == 0) {
            return 0;
        }
        int[][] left = new int[row][col];
        int[][] up = new int[row][col];
        left[0][0] = matrix[0][0];
        up[0][0] = matrix[0][0];
        int res = 1;

        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 1) {
                up[i][0] = up[i - 1][0] + 1;
                left[i][0] = 1;
            }
        }
        for (int j = 1; j < col; j++) {
            if (matrix[0][j] == 1) {
                left[0][j] = left[0][j - 1] + 1;
                up[0][j] = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;
                }
                int maxLength = Math.min(left[i][j], up[i][j]);
                for (int k = maxLength; k >= 1; k--) {
                    if (up[i][j - k + 1] >= k && left[i - k + 1][j] >= k) {
                        res = Math.max(res, k);
                        break;
                    }
                }
            }
        }
        return res;
    }
}
