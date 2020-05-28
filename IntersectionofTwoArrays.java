import java.util.ArrayList;
import java.util.List;

public class IntersectionofTwoArrays {
    public static void main(String[] args) {
        IntersectionofTwoArrays so = new IntersectionofTwoArrays();
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        A.add(128);
        B.add(128);
        so.common(A,B);
    }

    //method1: two pointers
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            int tmp = A.get(i).compareTo(B.get(j));
            if (tmp == 0) {
                res.add(A.get(i));
                i++;
                j++;
            } else if (tmp < 0) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}
