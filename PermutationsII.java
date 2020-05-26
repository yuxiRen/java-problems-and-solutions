public class PermutationsII {
    public List<String> permutations(String input) {
        List<String> res = new ArrayList<>();
        char[] arr = input.toCharArray();
        dfs(arr, 0, res);
        return res;
    }
    private void dfs(char[] arr, int idx, List<String> res) {
        if (idx == arr.length - 1) {
            res.add(String.valueOf(arr));
            return;
        }
        Set<Character> used = new HashSet<>();
        for (int i = idx; i < arr.length; i++) {
            if (used.add(arr[i])) {
                swap(arr, i, idx);
                dfs(arr, idx+1, res);
                swap(arr, i, idx);
            }
        }
    }
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
