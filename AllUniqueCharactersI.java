//'a' - 'z', the 26 lower case letters.
public class AllUniqueCharactersI {
    public boolean allUnique(String word) {
        int checker = 0;
        for (int i = 0; i < word.length(); i++) {
            int cur = word.charAt(i) - 'a';
            if (((1 << cur) & checker) != 0) {
                return false;
            }
            checker |= (1 << cur);
        }
        return true;
    }
}
