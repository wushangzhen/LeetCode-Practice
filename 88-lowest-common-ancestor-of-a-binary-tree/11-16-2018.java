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
    List<TreeNode> listGlobal = new LinkedList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p, new LinkedList<>());
        List<TreeNode> list1 = listGlobal;
        traverse(root, q, new LinkedList<>());
        List<TreeNode> list2 = listGlobal;
        int i = 0;
        TreeNode res = null;
        while (i < list1.size() && i < list2.size()) {
            if (list1.get(i).val != list2.get(i).val) {
                break;
            } else {
                res = list1.get(i);
                i++;
            }
        }
        return res;
    }
    void traverse(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        if (target.val == root.val) {
            list.add(root);
            listGlobal = new LinkedList<>(list);
            return;
        }
        list.add(root);
        traverse(root.left, target, list);
        traverse(root.right, target, list);
        list.remove(list.size() - 1);
    }
}
