class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stk = new Stack<>();
        int n = height.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (stk.isEmpty()) {
                stk.push(i);
            } else {
                while (!stk.isEmpty() && height[stk.peek()] <= height[i]) {
                    int index = stk.pop();
                    int h = height[index];
                    if (!stk.isEmpty()) {
                        int index2 = stk.peek();
                        sum += (Math.min(height[i], height[index2]) - h) * (i - index2 - 1);
                    }
                }
                stk.push(i);
            }
        }
        return sum;
    }
}
