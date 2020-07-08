public class TrappingRainWater {
    //method1
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int sum = 0;
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            sum += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return sum;
    }
    //method2
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                int curIdx = stack.pop();
                if (!stack.isEmpty()) {
                    sum += (Math.min(height[i], height[stack.peek()]) - height[curIdx])*(i-stack.peek()-1);
                }
            }
            stack.push(i);
        }
        return sum;
    }
}
