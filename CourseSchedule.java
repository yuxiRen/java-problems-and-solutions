public class CourseSchedule {
    //method1. DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int[] p : prerequisites) {
            if (!graph.containsKey(p[0])) {
                graph.put(p[0], new ArrayList<Integer>());
            }
            graph.get(p[0]).add(p[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int cur, int[] visited, Map<Integer, List<Integer>> graph) {
        if (visited[cur] == 1) {
            return true;
        }
        if (visited[cur] == 2) {
            return false;
        }
        List<Integer> prerequisites = graph.get(cur);
        if (prerequisites == null) {
            return true;
        }
        visited[cur] = 2;
        for (int p : prerequisites) {
            if (!dfs(p, visited, graph)) {
                return false;
            }
        }
        visited[cur] = 1;
        return true;
    }
    //method2. BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        for (int[] p : prerequisites) {
            if (!graph.containsKey(p[0])) {
                graph.put(p[0], new ArrayList<Integer>());
            }
            graph.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            if (graph.containsKey(cur)) {
                List<Integer> prev = graph.get(cur);
                for (int p : prev) {
                    indegree[p]--;
                    if (indegree[p] == 0) {
                        queue.offer(p);
                    }
                }
            }
        }

        return count == numCourses;
    }
}
