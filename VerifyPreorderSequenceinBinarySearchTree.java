public class VerifyPreorderSequenceinBinarySearchTree {
    //method1. DFS O(NlogN)
    public boolean verifyPreorder(int[] preorder) {
        return verifyPreorder(preorder, 0, preorder.length - 1);
    }
    private boolean verifyPreorder(int[] preorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = preorder[start];
        int i = start + 1;
        while (i <= end && preorder[i] < root) {
            i++;
        }
        for (int j = i; j <= end; j++) {
            if (preorder[j] < root) {
                return false;
            }
        }
        return verifyPreorder(preorder, start + 1, i - 1) && verifyPreorder(preorder, i, end);
    }
}
