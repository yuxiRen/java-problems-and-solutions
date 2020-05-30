public class IsSubsequence {
    public int strstr(String large, String small) {
        for (int i = 0; i <= large.length() - small.length(); i++) {
            for (int j = 0; j <= small.length(); j++) {
                if (j == small.length()) {
                    return i;
                }
                if (large.charAt(i + j) != small.charAt(j)) {
                    break;
                }
            }
        }
        return -1;
    }
}
