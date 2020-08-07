public class FindEventualSafeStates {
    //method1
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] outdegree = new int[n];
        Map<Integer, Set<Integer>> prevs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            outdegree[i] = graph[i].length;
            prevs.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < n; i++) {
            for (int next : graph[i]) {
                prevs.get(next).add(i);
            }
        }
        boolean[] safe = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            safe[cur] = true;
            for (int prev : prevs.get(cur)) {
                outdegree[prev]--;
                if (outdegree[prev] == 0) {
                    queue.offer(prev);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                res.add(i);
            }
        }
        return res;
    }
    //method2
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(i, graph, visited)) {
                res.add(i);
            }
        }
        return res;
    }
    private boolean dfs(int cur, int[][] graph, int[] visited) {
        if (visited[cur] == 1) {
            return true;
        }
        if (visited[cur] == 2) {
            return false;
        }
        visited[cur] = 2;
        for (int next : graph[cur]) {
            if (!dfs(next, graph, visited)) {
                return false;
            }
        }
        visited[cur] = 1;
        return true;
    }
}
