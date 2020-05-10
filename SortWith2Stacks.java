public class SortWith2Stacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        while (!s1.isEmpty()) {
          s2.push(s1.pop());
        }
        while (!s2.isEmpty()) {
          int cur = s2.pop();
          while (!s1.isEmpty() && s1.peek() < cur) {
            s2.push(s1.pop());
          }
          s1.push(cur);
        }
      }
}