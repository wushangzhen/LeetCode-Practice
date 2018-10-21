/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public int val;
 *     public ParentTreeNode parent, left, right;
 * }
 */


public class Solution {
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum3(ParentTreeNode root, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        traverse(root, target, result);
        return result;
    }
    void traverse(ParentTreeNode root, int target, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        List<Integer> path = new LinkedList<>();
        findSum(root, target, null, result, path);
        traverse(root.left, target, result);
        traverse(root.right, target, result);
    }
    void findSum(ParentTreeNode root, int target, ParentTreeNode father, 
        List<List<Integer>> result, List<Integer> path) {
        if (root == null) {
            return;
        }        
        path.add(root.val);
        target -= root.val;
        if (target == 0) {
            result.add(new ArrayList<>(path));
        }
        // father is use to avoid the repeat node
        if (root.parent != father) {
            findSum(root.parent, target, root, result, path);
        }
        if (root.left != father) {
            findSum(root.left, target, root, result, path);
        }
        if (root.right != father) {
            findSum(root.right, target, root, result, path);
        }
        path.remove(path.size() - 1);
    }
}
