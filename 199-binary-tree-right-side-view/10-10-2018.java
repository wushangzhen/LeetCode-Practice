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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        list.add(root.val);
        while (!q.isEmpty()) {
            int size = q.size();
            int flag = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.right != null) {
                    if (flag == list.size()) {
                        list.add(node.right.val);
                    }
                    q.add(node.right);
                    if (node.left != null) {
                        q.add(node.left);
                    }
                } else {
                    if (node.left != null) {
                        q.add(node.left);
                        if (flag == list.size()) {
                        list.add(node.left.val);
                        }
                    }
                }
            }
        } 
        return list;
    }
}
