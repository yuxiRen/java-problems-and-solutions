public class SortWith3Stacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        LinkedList<Integer> s3 = new LinkedList<Integer>();
       sort(s1, s2, s3, s1.size());
      }
    
      private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int size) {
        if (size <= 1) {
          return;
        }
        int mid1 = size / 2;
        int mid2 = size - mid1;
    
        for (int i = 0; i < mid2;i++) {
          s2.push(s1.pop());
        }
        sort(s2, s3, s1, mid2);
        sort(s1, s3, s2, mid1);
    
        int i = 0;
        int j = 0;
        while (i < mid1 && j < mid2) {
          if (s1.peek() > s2.peek()) {
            s3.push(s2.pop());
            j++;
          } else {
            s3.push(s1.pop());
            i++;
          }
        }
    
        while (i < mid1) {
    s3.push(s1.pop());
            i++;
        }
        while (j < mid2) {
    s3.push(s2.pop());
            j++;
        }
        for (int k = 0; k < size; k++) {
          s1.push(s3.pop());
        }
      }
}