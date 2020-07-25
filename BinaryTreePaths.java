public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, "");
        return res;
    }

    private void dfs(TreeNode root, List<String> res, String path) {
        if (root != null) {
            path += root.val;
            if (root.left == null && root.right == null) {
                res.add(path);
            } else {
                path += "->";
                dfs(root.left, res, path);
                dfs(root.right, res, path);
            }
        }
    }
}
