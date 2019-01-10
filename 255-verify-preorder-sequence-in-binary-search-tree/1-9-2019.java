class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        Stack<Integer> stk = new Stack<>();
        int low = Integer.MIN_VALUE;
        for (int a : preorder) {
            if (a < low) {
                return false;
            }
            while ((!stk.isEmpty()) && stk.peek() < a) {
                low = stk.pop();
            }
            stk.push(a);
        }
        return true;
    }
}
