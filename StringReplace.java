public class StringReplace {
    public String replace(String input, String source, String target) {
        StringBuilder sb = new StringBuilder();
        int fromIdx = 0;
        int matchIdx = input.indexOf(source, fromIdx);
        while (matchIdx != -1) {
            sb.append(input, fromIdx, matchIdx).append(target);
            fromIdx = matchIdx + source.length();
            matchIdx = input.indexOf(source, fromIdx);
        }
        sb.append(input, fromIdx, input.length());
        return sb.toString();
    }
}
