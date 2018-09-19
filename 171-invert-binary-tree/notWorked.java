public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        while (que.size() != 0) {
            TreeNode node = que.poll();
            if (node.left != null || node.right != null) {
                TreeNode temp = node.left; 
                node.left = node.right;
                node.right = temp;
                if (node.left == null && node.right != null) {
                    que.add(node.right);
                } else if (node.right == null && node.left != null) {
                    que.add(node.left);
                } else if (node.left != null && node.right != null) {
                    que.add(node.left);
                    que.add(node.right);
                }
            }
        }
    }
}
