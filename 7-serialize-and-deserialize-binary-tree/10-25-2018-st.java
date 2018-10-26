/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    String traverse(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
            return str;
        }
        str += root.val + ",";
        str = traverse(root.left, str);
        str = traverse(root.right, str);
        return str;
    }
    public String serialize(TreeNode root) {
        // write your code here
        return traverse(root, "");
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        String[] array = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(array));
        return helper(list);
    }
    TreeNode helper(List<String> array) {
        if (array.get(0).equals("null")) {
            //array.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(array.get(0)));
        array.remove(0);
        root.left = helper(array);
        array.remove(0);
        root.right = helper(array);
        return root;
    }
}
