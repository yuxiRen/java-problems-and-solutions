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

        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = s1.charAt(i) == s3.charAt(i) && dp[i - 1][0];
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = s2.charAt(i) == s3.charAt(i) && dp[0][i - 1];
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i) == s3.charAt(i + j)) || (dp[i][j - 1] && s2.charAt(j) == s3.charAt(i + j));
            }
        }

        return dp[len1][len2];
    }
}
