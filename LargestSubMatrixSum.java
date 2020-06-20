public class LargestSubMatrixSum {
    public int largest(int[][] matrix) {
        int res = Integer.MIN_VALUE;
        int row = matrix.length;
        int col = matrix[0].length;
        //traverse submatrix from the i-th row to the j-th row
        for (int i = 0; i < row; i++) {
            int[] curSum = new int[col];
            for (int j = i; j < row; j++) {
                //add the j-th row into prev sum
                add(curSum, matrix[j]);
                //find subarray's largest sum of curSum
                res = Math.max(res, max(curSum));
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
