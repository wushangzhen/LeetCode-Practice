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
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
       List<TreeNode> result = new ArrayList<>(); 
       if (n == 0) {
           result.add(null);
           return result;
       }
       return generate(1, n);
    }
    List<TreeNode> generate(int start, int end) {
        if (start > end) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }
        //if (start == end) {
        //    TreeNode node = new TreeNode(start);
        //    List<TreeNode> list = new ArrayList<>();
        //    list.add(node);
        //    return list;
        //}
        List<TreeNode> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> l = generate(start, i - 1);
            List<TreeNode> r = generate(i + 1, end);
            for (TreeNode lt : l) {
                for (TreeNode rt : r) {
                    TreeNode root = new TreeNode(i);
                    root.left = lt;
                    root.right = rt;
                    list.add(root);
                } 
            }
        }
        return list;
    }
}
