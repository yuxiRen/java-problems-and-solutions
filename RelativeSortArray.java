public class RelativeSortArray {
    public int[] sortSpecial(int[] A1, int[] A2) {
        int[] count = new int[1001];
        for (int a1 : A1) {
          count[a1]++;
        }
        int i = 0;
        for (int a2 : A2) {
          while (count[a2] > 0) {
            A1[i++] = a2;
            count[a2]--;
          }
        }
        for (int c = 0; c < count.length; c++) {
          while (count[c] > 0) {
            A1[i++] = c;
            count[c]--;
          }
        }
        return A1;
      }
}