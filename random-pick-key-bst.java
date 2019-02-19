class TreeNode {
    TreeNode left;
    TreeNode right;
    int size;
    int val;
} 
class Solution {
    Random rand = new Random();
    // input root should not be null;
    public int randomPickKeyBST(TreeNode root) {
        int key = rand.nextInt(root.size);
        int leftNum = root.left == null ? 0 : root.left.size;
        if (key == root.size - 1) {
            return root.val;
        } else if (key < leftNum) {
            return ramdomPickKeyBST(root.left);
        } else {
            return randomPickKeyBST(root.right);
        }
    }
}
