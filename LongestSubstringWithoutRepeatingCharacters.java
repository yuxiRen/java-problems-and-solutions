public class LongestSubstringWithoutRepeatingCharacters {
    public int longest(String input) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 0;
        while (fast < input.length()) {
            if (set.add(input.charAt(fast))) {
                res = Math.max(res, fast - slow + 1);
                fast++;
            } else {
                set.remove(input.charAt(slow));
                slow++;
            }
        }
        return res;
    }
}
