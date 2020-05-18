/*
Get the list of keys in a given binary search tree in a given range[min, max] in ascending order, 
both min and max are inclusive.

Examples

        5

      /    \

    3        8

  /   \        \

 1     4        11

get the keys in [2, 5] in ascending order, result is  [3, 4, 5]
*/
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