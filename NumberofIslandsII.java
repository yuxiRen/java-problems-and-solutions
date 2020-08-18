public class NumberofIslandsII {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[m * n];
        Arrays.fill(parent, -1);
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] position : positions) {
            int r = position[0];
            int c = position[1];
            if (parent[r * n + c] != -1) {
                res.add(count);
                continue;
            }
            parent[r * n + c] = r * n + c;
            count++;
            for (int k = 0; k < dir.length; k++) {
                int x = r + dir[k][0];
                int y = c + dir[k][1];
                if (x >= 0 && x < m && y >= 0 && y < n && parent[x * n + y] != -1 && find(x * n + y, parent) != find(r * n + c, parent)) {
                    union(x * n + y, r * n + c, parent);
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
}
