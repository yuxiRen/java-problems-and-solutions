public class RotateImage {
    public void rotate(int[][] matrix) {
        rotate(matrix, 0);
    }
    private void rotate(int[][] matrix, int start) {
        int n = matrix.length;
        if (start >= n / 2) {
            return;
        }
        int end = n - start - 1;
        for (int i = 0; i < end - start; i++) {
            int tmp = matrix[start][start + i];
            matrix[start][start + i] = matrix[end - i][start];
            matrix[end - i][start] = matrix[end][end - i];
            matrix[end][end - i] = matrix[start + i][end];
            matrix[start + i][end] = tmp;
        }
        rotate(matrix, start + 1);
    }
}
