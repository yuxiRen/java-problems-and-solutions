public class IsGraphBipartit {
    public boolean isBipartite(int[][] graph) {
        int[] group = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!BFS(i, graph, group)) {
                return false;
            }
        }
        return true;
    }

    private boolean BFS(int node, int[][] graph, int[] group) {
        if (group[node] != 0) {
            return true;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(node);
        group[node] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int neighborGroup = group[cur] == 1 ? -1 : 1;
            for (int neighbor : graph[cur]) {
                if (group[neighbor] == 0) {
                    group[neighbor] = neighborGroup;
                    queue.offer(neighbor);
                } else if (group[neighbor] != neighborGroup) {
                    return false;
                }
            }
        }
        return true;
    }
}
