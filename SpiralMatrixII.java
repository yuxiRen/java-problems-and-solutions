public class SpiralMatrixII {
    //method1: recursive generate
    public int[][] spiralGenerate(int n) {
        int[][] res = new int[n][n];
        recursiveGenerate(res, 0, 1, n);
        return res;
    }
    private void recursiveGenerate(int[][] res, int offset, int num, int size) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            res[offset][offset] = num;
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            res[offset][offset + i] = num++;
        }
        for (int i = 0; i < size - 1; i++) {
            res[offset + i][offset + size - 1] = num++;
        }
        for (int i = size - 1; i > 0; i--) {
            res[offset + size - 1][offset + i] = num++;
        }
        for (int i = size - 1; i > 0; i--) {
            res[offset + i][offset] = num++;
        }
        recursiveGenerate(res, offset + 1, num, size - 2);
    }
    //method2: iterative generate
    public int[][] spiralGenerate(int n) {
        int[][] res = new int[n][n];
        int start = 0;
        int end = n - 1;
        int num = 1;
        while (start < end) {
            for (int i = start; i < end; i++) {
                res[start][i] = num++;
            }
            for (int i = start; i < end; i++) {
                res[i][end] = num++;
            }
            for (int i = end; i > start; i--) {
                res[end][i] = num++;
            }
            for (int i = end; i > start; i--) {
                res[i][start] = num++;
            }
            start++;
            end--;
        }
        if (start == end) {
            res[start][start] = num;
        }
        return res;
    }
}
