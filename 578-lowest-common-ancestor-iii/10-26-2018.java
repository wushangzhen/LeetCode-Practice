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
 class ResultType {
     TreeNode node;
     boolean exA;
     boolean exB;
     public ResultType(TreeNode node, boolean exA, boolean exB) {
         this.node = node;
         this.exA = exA;
         this.exB = exB;
     }
 }


public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || A == null || B == null) {
            return null;
        }
        if (A.left == B || A.right == B) {
            return A;
        }
        if (B.left == A || B.right == A) {
            return B;
        }
        ResultType res = find(root, A, B);
        if (res.node != null) {
            return res.node;
        } else {
            return null;
        }
    }
    
    ResultType find(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(null, false, false);
        }
        if (root == A && A == B) {
            return new ResultType(root, true, true);
        }
        ResultType left = find(root.left, A, B);
        ResultType right = find(root.right, A, B);
        if (left.node != null || right.node != null) {
            if (left.node != null)
                return new ResultType(left.node, true, true);
            if (right.node != null)
                return new ResultType(right.node, true, true);
        } 
        if ((left.exA && right.exB) || (left.exB && right.exA)) {
            return new ResultType(root, true, true);
        }
        if (root == A && (right.exB || left.exB)) {
            return new ResultType(root, true, true);
        }
        if (root == B && (right.exA || left.exA)) {
            return new ResultType(root, true, true);
        }
        if (root == A || left.exA || right.exA) {
            return new ResultType(null, true, false);
        }
        if (root == B || left.exB || right.exB) {
            return new ResultType(null, false, true);
        }
        return new ResultType(null, false, false);
    }
}
