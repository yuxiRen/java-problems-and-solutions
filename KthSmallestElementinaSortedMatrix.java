public class KthSmallestElementinaSortedMatrix {
    class Solution {
        //Time: O(klogN)
        //Space: O(N)
        public int kthSmallest(int[][] matrix, int k) {
            int row = matrix.length;
            int col = matrix[0].length;
            boolean[][] visited = new boolean[row][col];
            PriorityQueue<Cell> minHeap = new PriorityQueue<> ((x, y) -> x.val-y.val);
            minHeap.offer(new Cell(0, 0, matrix[0][0]));
            for (int i = 0; i < k - 1; i++) {
                Cell cur = minHeap.poll();
                int r = cur.row;
                int c = cur.col;
                if (r + 1 < row && !visited[r + 1][c]) {
                    visited[r + 1][c] = true;
                    minHeap.offer(new Cell(r+1, c, matrix[r+1][c]));
                }
                if (c + 1 < col && !visited[r][c + 1]) {
                    visited[r][c + 1] = true;
                    minHeap.offer(new Cell(r, c+1, matrix[r][c+1]));
                }
            }
            return minHeap.peek().val;
        }

        static class Cell {
            int row;
            int col;
            int val;
            Cell(int r, int c, int v) {
                this.row = r;
                this.col = c;
                this.val = v;
            }
        }
    }
}
