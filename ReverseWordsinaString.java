public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        if (array.length == 0) {
            return "";
        }

        for (int i = array.length - 1; i >= 0; i--) {
            if (!array[i].equals("")) {
                sb.append(array[i]).append(' ');

            }
        }
        return sb.substring(0, sb.length() - 1);
    }
}
