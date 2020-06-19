public class RangeSumQuery2DImmutable {
    private int[][] sum;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //sum[i][j]: the sumRegion of(0, 0, i, j)
        sum = new int[m][n];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            sum[0][i] = sum[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //function2
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return sum[row2][col2];
        } else if (row1 == 0) {
            return sum[row2][col2] - sum[row2][col1 - 1];
        } else if (col1 == 0) {
            return sum[row2][col2] - sum[row1 - 1][col2];
        } else {
            //function1
            return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];
        }
    }
}
