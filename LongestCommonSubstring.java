public class LongestCommonSubstring {
    public String longestCommon(String source, String target) {
        int m = source.length();
        int n = target.length();
        int start = 0;
        int maxLength = 0;
        int[][] dp = new int[m + 1][n + 1];
        source = "*" + source;
        target = "*" + target;
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (source.charAt(i) == target.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > maxLength) {
                    maxLength = dp[i][j];
                    start = i - maxLength + 1;
                }
            }
        }
        return source.substring(start, start + maxLength);
    }
}
