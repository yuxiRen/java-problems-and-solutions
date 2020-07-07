public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= heights.length; i++) {
            int cur = (i == heights.length ? 0 : heights[i]);
            while (!stack.isEmpty() && heights[stack.peek()] >= cur) {
                int height = heights[stack.pop()];
                int leftBound = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, height * (i - leftBound - 1));
            }
            stack.push(i);
        }
        return res;
    }
}
