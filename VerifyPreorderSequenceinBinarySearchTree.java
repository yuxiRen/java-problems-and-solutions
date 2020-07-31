import java.util.Stack;

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
    //method2.
    public static boolean verifyPreorder(int[] preorder) {
        //descending stack
        Stack<Integer> stack = new Stack<>();

        int min = Integer.MIN_VALUE;
        for (int num : preorder) {
            //if the right subtree bigger than root, return false
            if (num < min) {
                return false;
            }
            //reach the right subtree
            while (!stack.isEmpty() && num > stack.peek()) {
                //pop all the leftsubtree & root
                //pick the root as the new boundary
                min = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }
}
