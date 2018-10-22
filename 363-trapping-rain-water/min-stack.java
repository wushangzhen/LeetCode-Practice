class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        Stack<Integer> stk = new Stack<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && height[stk.peek()] < height[i]) {
                int index = stk.pop();
                if (stk.isEmpty()) {
                    break;
                }
                int width = i - stk.peek() - 1;
                int tempHeight = Math.min(height[i], height[stk.peek()]) - height[index];
                ans += width * tempHeight;
            }
            stk.push(i);
        }
        return ans;
    }
}
