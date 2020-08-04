public class AlienDictionary {
    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
        Map<Character, Set<Character>> graph = new HashMap<>();
        build(indegree, graph, words);

        Queue<Character> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (char c : graph.keySet()) {
            if (indegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            char cur = queue.poll();

            sb.append(cur);
            if (graph.containsKey(cur)) {
                Set<Character> next = graph.get(cur);
                for (char n : next) {
                    indegree[n - 'a']--;
                    if (indegree[n - 'a'] == 0) {
                        queue.offer(n);
                    }
                }
            }
        }
        return sb.length() == graph.size() ? sb.toString() : "";
    }

    private void build(int[] indegree, Map<Character, Set<Character>> graph, String[] words) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<Character>());
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            int length = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < length; j++) {
                char first = words[i].charAt(j);
                char second = words[i + 1].charAt(j);
                if (first != second) {
                    if (!graph.get(first).contains(second)) {
                        indegree[second - 'a']++;
                        graph.getOrDefault(first, new HashSet<Character>()).add(second);
                    }
                    break;
                }
                //["abc","ab"]
                // ""
                if (j == length - 1 && words[i].length() > words[i + 1].length()) {
                    graph.clear();
                    return;
                }
            }
        }
    }
}
