public class RightShiftByNCharacters {
    public String rightShift(String input, int n) {
        if (input.length() == 0) {
            return input;
        }
        n %= input.length();
        String prev = input.substring(input.length() - n, input.length());
        String tail = input.substring(0, input.length() - n);
        return prev + tail;
    }
}
