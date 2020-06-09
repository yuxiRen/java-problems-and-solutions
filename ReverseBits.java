public class ReverseBits {
    public int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            int right = (n >> i) & 1;
            int left = (n >> (31 - i)) & 1;
            if (left != right) {
                n ^= (1 << i) | (1 << (31 - i));
            }
        }
        return n;
    }
}
