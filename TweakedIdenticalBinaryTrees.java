public class TweakedIdenticalBinaryTrees {
    //Time: O(4^(logN)) = O(N^2)
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
          return true;
        } else if (one == null || two == null || one.key != two.key) {
          return false;
        }
        return (isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)) 
        || (isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left));
      }
}