/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stk = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.isEmpty();
    
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stk.pop();
        pushAll(node.right);
        return node.val;
    }
    void pushAll(TreeNode node) {
        for (; node != null; node = node.left) {
            stk.push(node);
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
