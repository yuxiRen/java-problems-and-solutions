public class WordBreak {
    public boolean canBreak(String input, String[] dict) {
        Set<String> set = new HashSet<>();
        for (String s : dict) {
            set.add(s);
        }
        boolean[] canBreak = new boolean[input.length()];
        canBreak[0] = set.contains(input.substring(0, 1));
        for (int i = 1; i < canBreak.length; i++) {
            for (int j = 0; j < i; j++) {
                if (set.contains(input.substring(0, i + 1)) ||
                        (canBreak[j] && set.contains(input.substring(j + 1, i + 1)))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[canBreak.length - 1];
    }
}
