public class SpiralMatrix {
    //method1. recursive traversal
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        recursiveTraverse(matrix, 0, matrix.length, matrix[0].length, res);
        return res;
    }
    private void recursiveTraverse(int[][] matrix, int offset, int row, int col, List<Integer> res) {
        if (row == 0 || col == 0) {
            return;
        }
        if (row == 1) {
            for (int i = 0; i < col; i++) {
                res.add(matrix[offset][offset + i]);
            }
            return;
        }
        if (col == 1) {
            for (int i = 0; i < row; i++) {
                res.add(matrix[offset + i][offset + col - 1]);
            }
            return;
        }
        for (int i = 0; i < col - 1; i++) {
            res.add(matrix[offset][offset + i]);
        }
        for (int i = 0; i < row - 1; i++) {
            res.add(matrix[offset + i][offset + col - 1]);
        }
        for (int i = col - 1; i > 0; i--) {
            res.add(matrix[offset + row - 1][offset + i]);
        }
        for (int i = row - 1; i > 0; i--) {
            res.add(matrix[offset + i][offset]);
        }
        recursiveTraverse(matrix, offset + 1, row - 2, col - 2, res);
    }
    //method2. iterative trversal
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        while (left < right && up < down) {
            for (int i = left; i < right; i++) {
                res.add(matrix[up][i]);
            }
            for (int i = up; i < down; i++) {
                res.add(matrix[i][right]);
            }
            for (int i = right; i > left; i--) {
                res.add(matrix[down][i]);
            }
            for (int i = down; i > left; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            right--;
            up++;
            down--;
        }
        if (left > right || up > down) {
            return res;
        } else if (left == right) {
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][left]);
            }
        } else {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
        }

        return res;
    }
}
