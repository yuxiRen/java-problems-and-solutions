public class DecompressStringI {
    public String decompress(String input) {
        if (input.length() == 0) {
            return input;
        }
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < input.length()) {
            char ch = input.charAt(i);
            if (i != input.length() - 1 &&
                    input.charAt(i + 1) >= '1' && input.charAt(i + 1) <= '9') {
                int count = input.charAt(i + 1) - '0';
                for (int j = 0; j < count; j++) {
                    ans.append(ch);
                }
                i += 2;
            } else {
                ans.append(ch);
                i++;
            }
        }
        return ans.toString();
    }

}
