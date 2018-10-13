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
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode pre = null;
        TreeLinkNode cur = root;
        dummy.next = root;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (pre == null) {
                        dummy.next = cur.left;
                        pre = dummy;
                    } else {
                        pre.next = cur.left;
                    }
                    pre = pre.next;
                }
                if (cur.right != null) {
                    if (pre == null) {
                        dummy.next = cur.right;
                        pre = dummy;
                    } else {
                        pre.next = cur.right;
                    }
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = dummy.next;
            pre = null;
            dummy.next = null;
        }
    }
}
