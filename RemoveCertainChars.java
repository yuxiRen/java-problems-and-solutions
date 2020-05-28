public class RemoveCertainChars {
    public String remove(String input, String t) {
        Set<Character> set = new HashSet<>();
        char[] arr = input.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        int slow = 0;
        int fast = 0;
        while (fast < arr.length) {
            if (!set.contains(arr[fast])) {
                arr[slow++] = arr[fast];
            }
            fast++;
        }
        return new String(arr, 0, slow);
    }
}
