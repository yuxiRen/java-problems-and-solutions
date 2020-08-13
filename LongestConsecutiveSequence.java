public class LongestConsecutiveSequence {
    public int[] parent;
    public int[] size;
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        parent = new int[n];
        size = new int[n];
        //<value, idx>
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (idx.containsKey(nums[i])) {
                continue;
            }
            parent[i] = i;
            size[i] = 1;
            Integer prev = idx.get(nums[i] - 1);
            if (prev != null && find(i) != find(prev)) {
                union(i, prev);
            }
            Integer next = idx.get(nums[i] + 1);
            if (next != null && find(i) != find(next)) {
                union(i, next);
            }
            idx.put(nums[i], i);
        }
        int res = 0;
        for (int s : size) {
            res = Math.max(s, res);
        }
        return res;
    }
    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
            size[find(rootY)] += size[rootX];
        }
    }
}

