public class GetKeysInBSTInGivenRange {
    private List<Integer> res = new LinkedList<>();
    public List<Integer> getRange(TreeNode root, int min, int max) {
        if (root == null) {
        return res;
        }
        if (root.key > min) {
        getRange(root.left, min, max);
        }
        
        if (root.key >= min && root.key <= max) {
        res.add(root.key);
        }
        if (root.key < max) {
        getRange(root.right, min, max);
        }
        return res;
    }
}