public class EditDistance {
//    base case:
//    M[0][0] = 0, there’s no string to edit
//    state:
//    M[i][j] represents the minimum steps to edit one.substring(0, i + 1) and two.substring(0, j + 1)
//    induction rule:
//    M[i][j] =
//    case1. no need to edit: one.charAt(i) == two.charAt(j) →  M[i-1][j-1]
//            case2. MIN(distance[i - 1][j - 1] + 1, distance[i][j - 1] + 1,distance[i - 1][j] + 1)

    public int editDistance(String one, String two) {
        int[][] distance = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                if (i == 0) {
                    distance[i][j] = j;
                }else if (j == 0) {
                    distance[i][j] = i;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    distance[i][j] = Math.min(distance[i - 1][j - 1] + 1, distance[i][j - 1] + 1);
                    distance[i][j] = Math.min(distance[i][j], distance[i - 1][j] + 1);
                }
            }
        }
        return distance[one.length()][two.length()];
    }
}
