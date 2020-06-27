public class BinaryTreePathSumToTargetIII {
    public boolean exist(TreeNode root, int target) {
        List<TreeNode> prevPath = new ArrayList<>();
        return exist(root, prevPath, target);
    }
    private boolean exist(TreeNode root, List<TreeNode> prevPath, int target) {
        if (root == null) {
            return false;
        }
        prevPath.add(root);
        int tmp = 0;
        for (int i = prevPath.size() - 1; i >= 0; i--) {
            tmp += prevPath.get(i).key;
            if (tmp == target) {
                return true;
            }
        }
        if (exist(root.left, prevPath, target) || exist(root.right, prevPath, target)) {
            return true;
        }
        prevPath.remove(prevPath.size() - 1);
        return false;
    }
}
