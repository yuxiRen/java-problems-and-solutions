public class HexadecimalRepresentation {
    public String hex(int number) {
        if (number == 0) {
            return "0x0";
        }
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int cur = number % 16;
            if (cur < 10) {
                sb.append(cur);
            } else {
                sb.append((char)(cur - 10 + 'A'));
            }
            number /= 16;
        }
        return "0x" + sb.reverse().toString();
    }
}
