public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Map<String, Integer> emailToId = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                emailToId.putIfAbsent(email, i);
                union(i, emailToId.get(email), parent);
            }
        }
        Map<Integer, List<String>> idToEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToId.entrySet()) {
            int id = find(entry.getValue(), parent);
            idToEmails.putIfAbsent(id, new ArrayList<String>());
            idToEmails.get(id).add(entry.getKey());
        }
        List<List<String>> res = new ArrayList<>();
        for (int id : idToEmails.keySet()) {

            List<String> account = new ArrayList<>();
            //name
            account.add(accounts.get(id).get(0));
            List<String> emails = idToEmails.get(id);
            Collections.sort(emails);
            account.addAll(emails);
            res.add(account);
        }
        return res;
    }
}
