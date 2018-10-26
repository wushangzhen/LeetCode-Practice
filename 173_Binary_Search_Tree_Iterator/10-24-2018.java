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
    Stack<TreeNode> stk;

    public BSTIterator(TreeNode root) {
        stk = new Stack<>();
        pushAll(root, stk);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.isEmpty();
        
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stk.pop();
        pushAll(node.right, stk);
        return node.val;
    }
    void pushAll(TreeNode node, Stack<TreeNode> stk) {
        while (node != null) {
            stk.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
