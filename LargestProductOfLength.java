public class LargestProductOfLength {
    public int largestProduct(String[] dict) {
        int[] mask = new int[dict.length];
        for (int i = 0; i < dict.length; i++) {
            char[] arr = dict[i].toCharArray();
            for (char c : arr) {
                mask[i] |= 1<<(c - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < dict.length - 1; i++) {
            for (int j = i + 1; j < dict.length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    res = Math.max(res, dict[i].length() * dict[j].length());
                }
            }
        }
        return res;
    }
}
