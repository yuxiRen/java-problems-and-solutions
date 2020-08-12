public class NumberofConnectedComponentsinanUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int ans = n;
        for (int[] edge : edges) {
            if (find(edge[0], parent) != find(edge[1], parent)) {
                union(edge[0], edge[1], parent);
                ans--;
            }
        }
        return ans;
    }
}
