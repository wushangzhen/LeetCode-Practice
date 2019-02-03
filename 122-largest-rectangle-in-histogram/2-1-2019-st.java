class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stk = new Stack<>();
        int n = heights.length;
        // 维持一个单调递增stack这样的话，就可以每次pop出来的时候根据当前坐标计算面积
        // 注意最后压入-1进行所有的清算
        int max = 0;
        for (int i = 0; i <= n; i++) {
            int cur = (i == n) ? -1 : heights[i];
            while (!stk.isEmpty() && cur <= heights[stk.peek()]) {
                int h = heights[stk.pop()];
                int w = stk.isEmpty() ? i : i - stk.peek() - 1;
                max = Math.max(max, h * w);
            }
            stk.push(i);
        }
        return max;
    }
}
