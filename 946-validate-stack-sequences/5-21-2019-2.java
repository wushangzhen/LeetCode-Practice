class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int n = pushed.length;
        int j = 0;
        int i = 0;
        for (i = 0; i < n; i++) {
            stk.push(pushed[i]);
            while (!stk.isEmpty() && j < n && stk.peek() == popped[j]) {
                stk.pop();
                j++;
            }
        }
        return j == n;
    }
}
