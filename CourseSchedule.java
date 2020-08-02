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
}
