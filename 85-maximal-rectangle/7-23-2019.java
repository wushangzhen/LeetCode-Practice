class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[] last = new int[n];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] now = new int[n];
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    now[j] = last[j] + 1; 
                }
            }
            max = Math.max(max, helper(now));
            last = now;
        }
        return max;
    }
    
    int helper(int[] x) {
        int max = 0;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i <= x.length; i++) {
            int temp = i == x.length ? -1: x[i];
            while (!stk.isEmpty() && x[stk.peek()] >= temp) {
                int h = x[stk.pop()];
                int w = stk.isEmpty() ? i : i - stk.peek() - 1;
                max = Math.max(max, h * w);
            }
            stk.push(i);
        }
        return max;
    }
}
