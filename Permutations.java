public class Permutations {
    public List<String> permutations(String input) {
        List<String> res = new ArrayList<>();
        if (input.length() == 0) {
            res.add("");
            return res;
        }
        char[] arr = input.toCharArray();
        dfs(arr, 0, res);
        return res;
    }
    private void dfs(char[] arr, int idx, List<String> res) {
        if (idx == arr.length) {
            res.add(new String(arr));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            swap(arr, i, idx);
            dfs(arr, idx+1, res);
            swap(arr, i, idx);
        }
    }
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
