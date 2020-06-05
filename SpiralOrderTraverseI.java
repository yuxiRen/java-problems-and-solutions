//Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner.
// Return the list of traversal sequence.
public class SpiralOrderTraverseI {
    //method1. recursive traversal
    public List<Integer> spiral(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        recursiveTraverse(matrix, 0, matrix.length, res);
        return res;
    }
    private void recursiveTraverse(int[][] matrix, int offset, int size, List<Integer> res) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            res.add(matrix[offset][offset]);
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            res.add(matrix[offset][offset + i]);
        }
        for (int i = 0; i < size - 1; i++) {
            res.add(matrix[offset + i][offset + size - 1]);
        }
        for (int i = size - 1; i > 0; i--) {
            res.add(matrix[offset + size - 1][offset + i]);
        }
        for (int i = size - 1; i > 0; i--) {
            res.add(matrix[offset + i][offset]);
        }
        recursiveTraverse(matrix, offset + 1, size - 2, res);
    }
}
