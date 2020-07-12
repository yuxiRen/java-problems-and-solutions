public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 + len2 != s3.length()) {
            return false;
        }
        s1 = "#" + s1;
        s2 = "#" + s2;
        s3 = "#" + s3;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = s2.charAt(j) == s3.charAt(i + j) && dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = s1.charAt(i) == s3.charAt(i + j) && dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i) == s3.charAt(i + j)) || (dp[i][j - 1] && s2.charAt(j) == s3.charAt(i + j));
                }
            }
        }

        return dp[len1][len2];
    }
}
