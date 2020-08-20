public class MaximumXORofTwoNumbersinanArray {

    public int findMaximumXOR(int[] nums) {
        //Trie tree的高度
        int height = 0;
        for (int num : nums) {
            height = Math.max(height, Integer.toBinaryString(num).length());
        }
        String[] numsStr = new String[nums.length];
        //bit操作中怎么调整一个二进制数的位数
        int bitMask = 1 << height;
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = Integer.toBinaryString(nums[i] | bitMask).substring(1);
        }
        TrieNode root = new TrieNode();
        int res = 0;
        for (String nStr : numsStr) {
            TrieNode curInsert = root;
            TrieNode curCal = root;
            int curXor = 0;
            //每insert一个数进Trie里，同时找到能与其亦或产生的最大值
            //一定是先可着最高位能亦或就先亦或上
            for (char c : nStr.toCharArray()) {
                int bit = c == '0' ? 0 : 1;
                //insert into Trie tree
                if (curInsert.children[bit] == null) {
                    curInsert.children[bit] = new TrieNode();
                }
                curInsert = curInsert.children[bit];
                //calculate xor
                //从高到低位开始亦或，无论如何currXor每次都要左移一位
                int xorBit = bit == 1 ? 0 : 1;
                if (curCal.children[xorBit] == null) {
                    curXor <<= 1;
                    curCal = curCal.children[bit];
                } else {
                    curXor = (curXor << 1) | 1;
                    curCal = curCal.children[xorBit];
                }
            }
            res = Math.max(res, curXor);
        }
        return res;
    }

    class TrieNode {
        TrieNode[] children;
        public TrieNode () {
            //只有0，1两个叉
            this.children = new TrieNode[2];
        }
    }
}
