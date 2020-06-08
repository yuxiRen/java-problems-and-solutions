//using ASCII charset, the value of valid characters are from 0 to 255
public class AllUniqueCharactersII {
    public boolean allUnique(String word) {
        int[] map = new int[8];
        for (int i = 0; i < word.length(); i++) {
            int cur = (int)word.charAt(i);
            int checker = map[cur / 32];
            int offset = cur % 32;
            if (((1 << offset) & checker) != 0 ) {
                return false;
            }
            map[cur / 32] |= (1 << offset);
        }
        return true;
    }
}
