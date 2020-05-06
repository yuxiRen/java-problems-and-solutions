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

      public int[] sortSpecial(int[] A1, int[] A2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int a1 : A1) {
          map.put(a1, map.getOrDefault(a1, 0) + 1);
        }
        int i = 0;
        for (int a2 : A2) {
          while (map.get(a2) != null && map.get(a2) > 0) {
            A1[i++] = a2;
            map.put(a2, map.get(a2) - 1);
          }
        }
        for (int n : map.keySet()) {
          while (map.get(n) > 0) {
            A1[i++] = n;
            map.put(n, map.get(n) - 1);
          }
        }
        return A1;
      }
}