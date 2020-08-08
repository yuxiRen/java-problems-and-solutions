public class SortItemsbyGroupsRespectingDependencies {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int[] res = new int[n];
        Map<Integer, Set<Integer>> groupMap = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Set<Integer>> next = new HashMap<>();
        int groupId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                groupMap.put(groupId, new HashSet<Integer>());
                group[i] = groupId++;
            }else if (!groupMap.containsKey(group[i])) {
                groupMap.put(group[i], new HashSet<Integer>());
            }
            groupMap.get(group[i]).add(i);
            indegree.put(i, 0);
        }
        //build graph inside each group
        for (int i = 0; i < n; i++) {
            List<Integer> beforeList = beforeItems.get(i);
            for (int b : beforeList) {
                if (group[b] != group[i]) {
                    continue;
                }
                if (!next.containsKey(b)) {
                    next.put(b, new HashSet<Integer>());
                }
                next.get(b).add(i);
                indegree.put(i, indegree.get(i) + 1);
            }
        }
        //toplogical sort inside each group
        Map<Integer, List<Integer>> grougNodesOrdered = new HashMap<>();
        for (int id : groupMap.keySet()) {
            List<Integer> tmp = toplogicalSort(groupMap.get(id), indegree, next);
            if (tmp.size() == 0) {
                return new int[]{};
            }
            grougNodesOrdered.put(id, tmp);
        }
        //build graph among groups
        next.clear();//<groupId, List<groupId>>
        indegree.clear();
        for (int i = 0; i < n; i++) {
            List<Integer> beforeList = beforeItems.get(i);
            if (!indegree.containsKey(group[i])) {
                indegree.put(group[i], 0);
            }
            for (int b : beforeList) {
                if (group[b] == group[i]) {
                    continue;
                }
                if (!next.containsKey(group[b])) {
                    next.put(group[b], new HashSet<Integer>());
                }
                next.get(group[b]).add(group[i]);
                indegree.put(group[i], indegree.get(group[i]) + 1);
            }
        }

        //toplogical sort among groups
        List<Integer> orderedGroup = toplogicalSort(groupMap.keySet(), indegree, next);
        if (orderedGroup.size() == 0) {
            return new int[]{};
        }
        int idx = 0;
        for (int gId : orderedGroup) {
            List<Integer> nodes = grougNodesOrdered.get(gId);
            for (int node : nodes) {
                res[idx++] = node;
            }
        }
        return res;
    }
    private List<Integer> toplogicalSort(Set<Integer> set, Map<Integer, Integer> indegree, Map<Integer, Set<Integer>> next) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i : set) {
            if (indegree.get(i) == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res.add(cur);
            Set<Integer> s = next.get(cur) == null ? new HashSet<Integer>() : next.get(cur);
            for (int n : s) {
                indegree.put(n, indegree.get(n) - 1);
                if (indegree.get(n) == 0) {
                    queue.offer(n);
                }
            }
        }
        //System.out.println(res.size()+", "+set.size());
        return res.size() == set.size() ? res : new ArrayList<Integer>();
    }
}
