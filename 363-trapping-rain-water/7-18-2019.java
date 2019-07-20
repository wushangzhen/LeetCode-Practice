class Solution {
    public int trap(int[] height) {
        Stack<Integer> stk = new Stack<>();
        int n = height.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (stk.isEmpty() || height[stk.peek()] > height[i]) {
                stk.push(i);
            } else {
                while (!stk.isEmpty() && height[stk.peek()] <= height[i]) {
                    int h = height[stk.pop()];
                    if (stk.isEmpty()) {
                        break;
                    } else {
                        int l = stk.peek();
                        sum += (Math.min(height[i], height[l]) - h) * (i - stk.peek() - 1);
                    }
                }
                stk.push(i);
            }
        }
        return sum;
    }
}
