/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Stack<TreeNode> stk = new Stack<TreeNode>();
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        
        if(root == null) {
            return result;
        }
        pushAll(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            if (node.right != null) {
                pushAll(node.right);
            }
        }
        return result;
    }
    void pushAll(TreeNode node) {
        for (; node != null; node = node.left) {
            stk.push(node);
            result.add(node.val);
        }
    }
    
}
