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
    String traverse(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
            return str;
        }
        str += String.valueOf(root.val) + ",";
        str = traverse(root.left, str);
        str = traverse(root.right, str);
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return traverse(root, "");
        
    }
    
    public TreeNode decode(List<String> list) {
        if (list.get(0).equals("null")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left = decode(list);
        root.right = decode(list);
        return root;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(strs));
        return decode(list);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
