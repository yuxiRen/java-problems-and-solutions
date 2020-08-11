public class FriendCircles {
    private int[] root;
    private int[] rank;
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int res = n;
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1 && find(i) != find(j)) {
                    union(i, j);
                    res--;
                }
            }
        }
        return res;
    }
    private int find(int x) {
        if (x != root[x]) {
            root[x] = find(root[x]);
        }
        return root[x];
    }
    private void union(int x, int y) {
        if (rank[root[x]] > rank[root[y]]) {
            root[root[y]] = x;
        } else if (rank[root[x]] < rank[root[y]]) {
            root[root[x]] = y;
        } else {
            root[root[x]] = y;
            rank[y]++;
        }
    }
}
