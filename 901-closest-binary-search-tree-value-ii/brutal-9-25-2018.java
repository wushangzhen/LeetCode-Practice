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
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (root == null || k == 0) {
            return result;
        }
        ArrayList<Integer> list = traverse(root);
        int i = 0;
        while (i < list.size() && list.get(i) <= target) {
            i++;
        }
        System.out.println(i);
        int left = i - 1;
        int right = i;
        while (result.size() < k && left >= 0 && right < list.size()) {
            if (target - list.get(left) > list.get(right) - target) {
                result.add(list.get(right));
                right++;
            } else {
                result.add(list.get(left));
                left--;
            }
        }
        if (result.size() == k) {
            return result;
        }
        if (left == -1) {
            while (result.size() < k) {
                result.add(list.get(right));
                right++;
            }
        }
        if (right == list.size()) {
            while (result.size() < k) {
                result.add(list.get(left));
                left--;
            }
        }
        return result;
    }
    
    ArrayList<Integer> traverse(TreeNode node) {
        ArrayList<Integer> array = new ArrayList<>();
        helper(node, array);
        return array;
    }
    
    void helper(TreeNode node, ArrayList<Integer> array) {
        if (node == null) {
            return;
        }
        helper(node.left, array);
        array.add(node.val);
        helper(node.right, array);
    }
}
