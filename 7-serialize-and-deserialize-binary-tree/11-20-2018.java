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
        traverse(root, sb);
        String str = sb.toString();
        
        return str;
    }
    void traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null");
            sb.append('#');
            return;
        }
        sb.append(root.val);
        sb.append('#');
        traverse(root.left, sb);
        traverse(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split("#");
        List<String> list = new LinkedList<>(Arrays.asList(strs));
        return helper(list);
    }
    TreeNode helper(List<String> list) {
        if (list.size() == 0 || list.get(0).equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = helper(list);
        list.remove(0);
        root.right = helper(list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
