class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int n = pushed.length;
        int j = 0;
        int i = 0;
        for (i = 0; i < n; i++) {
            while (i < n && pushed[i] != popped[j]) {
                stk.push(pushed[i]);
                i++;
            }
            if (i < n && pushed[i] == popped[j]) {
                j++;
                while (!stk.isEmpty() && j < n && stk.peek() == popped[j]) {
                    j++;
                    stk.pop();
                }
            }
        }
        return stk.isEmpty() && i == n && j == n;
    }
}
