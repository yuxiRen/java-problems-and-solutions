public class CourseScheduleIV {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        int[] indegree = new int[n];
        Map<Integer, Set<Integer>> postMap = new HashMap<>();
        Map<Integer, Set<Integer>> prevMap = new HashMap<>();
        for (int[] p : prerequisites) {
            if (!postMap.containsKey(p[0])) {
                postMap.put(p[0], new HashSet<Integer>());
            }
            postMap.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
            prevMap.put(i, new HashSet<Integer>());
            prevMap.get(i).add(i);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            Set<Integer> postSet = postMap.getOrDefault(cur, new HashSet<Integer>());
            Set<Integer> prevSet = prevMap.get(cur);
            for (int post : postSet) {
                for (int prev : prevSet) {
                    prevMap.get(post).add(prev);
                }
                indegree[post]--;
                if (indegree[post] == 0) {
                    queue.offer(post);
                }
            }
        }
        for (int[] query : queries) {
            res.add(prevMap.get(query[1]).contains(query[0]));
        }
        return res;
    }
}
