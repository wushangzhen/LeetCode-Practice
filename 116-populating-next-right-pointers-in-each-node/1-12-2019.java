/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        TreeLinkNode last = null;
        while (!q.isEmpty()) {
            int size = q.size();
            last = null;
            for (int i = 0; i < size; i++) {
                TreeLinkNode temp = q.poll();
                if (last != null) {
                    last.next = temp;
                }
                last = temp;
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }
}
