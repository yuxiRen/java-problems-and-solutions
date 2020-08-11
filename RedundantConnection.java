public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] root = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (find(a, root) == find(b, root)) {
                return edge;
            } else {
                union(a, b, root);
            }
        }
        return new int[2];
    }
    private int find(int x, int[] root) {
        if (x != root[x]) {
            root[x] = find(root[x], root);
        }
        return root[x];
    }
    private void union(int x, int y, int[] root) {
        root[find(x, root)] = find(y, root);
    }
}
