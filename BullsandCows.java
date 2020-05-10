//count[i]++: read from secret
//count[i]--: read from secret
public class BullsandCows {
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                A++;
            } else {
                if (count[s] < 0) {
                    B++;
                }
                if (count[g] > 0) {
                    B++;
                }
                count[s]++;
                count[g]--;
            }
        }
        return A+"A"+B+"B";
    }
}