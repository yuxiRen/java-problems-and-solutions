public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        int nodes = 1;
        String[] str = preorder.split(",");
        for (String s : str) {
            nodes--;
            if (nodes < 0) {
                return false;
            }
            if (!s.equals("#")) {
                nodes += 2;
            }
        }
        return nodes == 0;
    }
}
