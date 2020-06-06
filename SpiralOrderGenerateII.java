//Generate an M * N 2D array in spiral order clock-wise starting from the top left corner,
// using the numbers of 1, 2, 3, …, M * N in increasing order.
public class SpiralOrderGenerateII {
    //method1: recursive generate
    public int[][] spiralGenerate(int m, int n) {
        int[][] res = new int[m][n];
        recursiveGenerate(m, n, 0, 1, res);
        return res;
    }
    private void recursiveGenerate(int m, int n, int offset, int num, int[][] res) {
        if (m == 0 || n == 0) {
            return;
        }
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                res[offset][offset + i] = num++;
            }
            return;
        }
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                res[offset + i][offset] = num++;
            }
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            res[offset][offset + i] = num++;
        }
        for (int i = 0; i < m - 1; i++) {
            res[offset + i][offset + n - 1] = num++;
        }
        for (int i = n - 1; i > 0; i--) {
            res[offset + m - 1][offset + i] = num++;
        }
        for (int i = m - 1; i > 0; i--) {
            res[offset + i][offset] = num++;
        }
        recursiveGenerate(m - 2, n - 2, offset + 1, num, res);
    }
    //method2: iterative generate
    public int[][] spiralGenerate(int m, int n) {
        int[][] res = new int[m][n];
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;
        while (up < down && left < right) {
            for (int i = left; i < right; i++) {
                res[up][i] = num++;
            }
            for (int i = up; i < down; i++) {
                res[i][right] = num++;
            }
            for (int i = right; i > left; i--) {
                res[down][i] = num++;
            }
            for (int i = down; i > up; i--) {
                res[i][left] = num++;
            }
            left++;
            right--;
            up++;
            down--;
        }
        if (left == right) {
            for (int i = up; i <= down; i++) {
                res[i][left] = num++;
            }
        }
        if (up == down) {
            for (int i = left; i <= right; i++) {
                res[up][i] = num++;
            }
        }
        return res;
    }

}
