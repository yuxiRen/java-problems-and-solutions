public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int count = n;
        for (int[] edge : edges) {
            if (find(edge[0], parent) == find(edge[1], parent)) {
                return false;
            } else {
                union(edge[0], edge[1], parent);
                count--;
            }
        }
        return count == 1;
    }
}
