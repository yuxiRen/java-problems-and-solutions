public class HouseRobberIII {
    //method1
    public int rob(TreeNode root) {
        return dfs(root, false);
    }
    private int dfs(TreeNode root, boolean noRob) {
        if (root == null) {
            return 0;
        }
        int tmp = dfs(root.left, false) + dfs(root.right, false);
        if (noRob) {
            return tmp;
        } else {
            return Math.max(root.val + dfs(root.left, true) + dfs(root.right, true), tmp);
        }
    }
    //method2
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    private int[] dfs(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
