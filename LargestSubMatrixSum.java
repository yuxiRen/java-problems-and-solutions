public class LargestSubMatrixSum {
    public int largest(int[][] matrix) {
        int res = Integer.MIN_VALUE;
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            int[] cur = new int[col];
            for (int j = i; j < row; j++) {
                add(cur, matrix[j]);
                res = Math.max(res, max(cur));
            }
        }
        return res;
    }
    private void add(int[] arr, int[] matrix) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += matrix[i];
        }
    }
    private int max(int[] arr) {
        int res = arr[0];
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            tmp = Math.max(tmp + arr[i], arr[i]);
            res = Math.max(res, tmp);
        }
        return res;
    }
}
