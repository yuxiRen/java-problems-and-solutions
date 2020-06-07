public class ValidWordAbbreviation {
    //method1. recursion
    public boolean match(String input, String pattern) {
        return recursiveMatch(input, pattern, 0, 0);
    }
    private boolean recursiveMatch(String input, String pattern, int inputIdx, int patternIdx) {
        if (inputIdx == input.length() && patternIdx == pattern.length()) {
            return true;
        }
        if (inputIdx >= input.length() || patternIdx >= pattern.length()) {
            return false;
        }
        char cur = pattern.charAt(patternIdx);
        if (cur < '0' || cur > '9') {
            if (cur == input.charAt(inputIdx)) {
                return recursiveMatch(input, pattern, inputIdx + 1, patternIdx + 1);
            } else {
                return false;
            }
        } else {
            int count = 0;
            while (patternIdx < pattern.length() && pattern.charAt(patternIdx) >= '0' && pattern.charAt(patternIdx) <= '9') {
                count = count * 10 + (pattern.charAt(patternIdx) - '0');
                patternIdx++;
            }
            return recursiveMatch(input, pattern, inputIdx + count, patternIdx);
        }
    }
    //method2: iteration
    public boolean match(String input, String pattern) {
        int inputIdx = 0;
        int patternIdx = 0;
        while (inputIdx < input.length() && patternIdx < pattern.length()) {
            char cur = pattern.charAt(patternIdx);
            if (cur < '0' || cur > '9') {
                if (cur != input.charAt(inputIdx)) {
                    return false;
                }
                inputIdx++;
                patternIdx++;
            } else {
                int count = 0;
                while (patternIdx < pattern.length() && pattern.charAt(patternIdx) >= '0' && pattern.charAt(patternIdx) <= '9') {
                    count = count * 10 + (pattern.charAt(patternIdx) - '0');
                    patternIdx++;
                }
                inputIdx += count;
            }
        }
        return inputIdx == input.length() && patternIdx == pattern.length();
    }
}
