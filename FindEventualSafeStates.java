public class FindEventualSafeStates {
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
}
