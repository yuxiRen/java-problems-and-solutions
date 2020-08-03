public class CourseScheduleII {
    //method1. dfs
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        List<Integer> tmp = new ArrayList<>();
        //build graph
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int[] p : prerequisites) {
            if (!graph.containsKey(p[1])) {
                graph.put(p[1], new ArrayList<Integer>());
            }
            graph.get(p[1]).add(p[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, graph, tmp)) {
                return new int[]{};
            }
        }
        int[] res = new int[numCourses];
        int idx = numCourses - 1;
        for (int t : tmp) {
            res[idx--] = t;
        }
        return res;
    }

    private boolean dfs(int cur, int[] visited, Map<Integer, List<Integer>> graph, List<Integer> tmp) {
        if (visited[cur] == 1) {
            return true;
        }
        //there exist a circle
        if (visited[cur] == 2) {
            return false;
        }

        visited[cur] = 2;
        List<Integer> prerequisites = graph.getOrDefault(cur, new ArrayList());
        for (int p : prerequisites) {
            if (!dfs(p, visited, graph, tmp)) {
                return false;
            }
        }
        visited[cur] = 1;
        tmp.add(cur);
        return true;
    }
    //mrthod2. bfs
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {
            if (!graph.containsKey(p[1])) {
                graph.put(p[1], new ArrayList<>());
            }
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int idx = 0;
        while (!queue.isEmpty()) {
            res[idx] = queue.poll();
            if (graph.containsKey(res[idx])) {
                List<Integer> next = graph.get(res[idx]);
                for (int n : next) {
                    indegree[n]--;
                    if (indegree[n] == 0) {
                        queue.offer(n);
                    }
                }
            }
            idx++;
        }

        return idx == numCourses ? res : new int[]{};
    }
}
