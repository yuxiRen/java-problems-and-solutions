public class CourseScheduleII {
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
