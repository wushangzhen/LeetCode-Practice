/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper1(root, sb);
        return sb.toString();
    }
    void helper1(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        helper1(root.left, sb);
        helper1(root.right, sb);
        sb.append(root.val).append(",");
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datas = data.split("\\,");
        return helper2(datas, 0, datas.length - 1);
    }
    TreeNode helper2(String[] datas, int start, int end) {
        if (start > end || end < 0 || datas[end].equals("")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(datas[end]));
        int left = end;
        while (left >= 0 && Integer.parseInt(datas[left]) >= root.val) {
            left--;
        }
        root.left = helper2(datas, start, left);
        root.right = helper2(datas, left + 1, end - 1);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
