public class NumberofIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[] parent = new int[m * n];
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0},};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    parent[i * n + j] = i * n + j;
                    count++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    for (int k = 0; k < dir.length; k++) {
                        int r = i + dir[k][0];
                        int c = j + dir[k][1];
                        if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1' && find(i * n + j, parent) != find(r * n + c, parent)) {
                            union(i * n + j, r * n + c, parent);
                            count--;
                        }
                    }
                }
            }
        }
        return count;
    }

    private int find(int x, int[] parent) {
        if (x != parent[x]) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private void union(int x, int y, int[] parent) {
        parent[find(x, parent)] = find(y, parent);

    }
}
