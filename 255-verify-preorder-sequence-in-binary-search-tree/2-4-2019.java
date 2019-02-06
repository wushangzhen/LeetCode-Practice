class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        Stack<Integer> stk = new Stack<>();
        int low = Integer.MIN_VALUE;
        for (int i : preorder) {
            if (low >= i) {
                return false;
            }
            while (!stk.isEmpty() && i >= stk.peek()) {
                low = stk.pop();
            }
            stk.push(i);
        }
        return true;
    }
}
