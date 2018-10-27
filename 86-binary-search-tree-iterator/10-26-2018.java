/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */


public class BSTIterator {
    /*
    * @param root: The root of binary tree.
    */
    Stack<TreeNode> stk;
    public BSTIterator(TreeNode root) {
        // do intialization if necessary
        stk = new Stack<>();
        pushAll(root);
    }
    void pushAll(TreeNode node) {
        while (node != null) {
            stk.push(node);
            node = node.left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !stk.isEmpty();
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        if (hasNext()) {
            TreeNode node = stk.pop();
            TreeNode right = node.right;
            pushAll(right);
            return node;
        } else {
            return null;
        }
    }
}
