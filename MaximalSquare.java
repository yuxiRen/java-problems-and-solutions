public class MaximalSquare {
    public int largest(int[][] matrix) {
        int N = matrix.length;
        int[][] largest = new int[N][N];
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == 0) {
                    largest[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    largest[i][j] = Math.min(largest[i - 1][j], largest[i][j - 1]);
                    largest[i][j] = Math.min(largest[i][j], largest[i - 1][j - 1]) + 1;
                }
                res = Math.max(res, largest[i][j]);
            }
        }
        return res;
    }
}
