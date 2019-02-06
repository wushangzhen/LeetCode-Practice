class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }
        String[] strs = preorder.split(",");
        int n = strs.length;
        Stack<String> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            String cur = strs[i];
            while (cur.equals("#") && !stk.isEmpty() && stk.peek().equals(cur)) {
                stk.pop();
                if (stk.isEmpty()) {
                    return false;
                }
                stk.pop();
            }
            stk.push(cur);
        }
        return stk.size() == 1 && stk.peek().equals("#");
    }
}
