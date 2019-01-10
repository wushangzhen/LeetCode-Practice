class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        int low = Integer.MIN_VALUE;
        int i = -1;
        for (int a : preorder) {
            if (a < low) {
                return false;
            }
            while (i >= 0 && a > preorder[i]) {
                low = preorder[i--];
            }
            preorder[++i] = a;
        }
        return true;
    }
}
