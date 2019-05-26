class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stk = new Stack<>();
        int n = T.length;
        int[] res = new int[n];
        for (int i = 0; i < T.length; i++) {
            while (!stk.isEmpty() && T[i] > T[stk.peek()]) {
                res[stk.peek()] = i - stk.pop();
            }
            stk.push(i);
        }
        return res;
    }
}
