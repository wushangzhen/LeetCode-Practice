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
        TreeLinkNode cur = root;
        TreeLinkNode head = root;
        TreeLinkNode last = null;
        while (cur != null) {
            if (last == null) {
                head = cur.left;
            }
            if (cur.left != null) {
                if (last != null) {
                   last.next = cur.left; 
                }
                last = cur.left;
            }
            if (cur.right != null) {
                last.next = cur.right;
                last = cur.right;
            }
            if (cur.next == null) {
                cur = head;
                last = null;
            } else {
                cur = cur.next;
            }
        }
        return;
    }
}
