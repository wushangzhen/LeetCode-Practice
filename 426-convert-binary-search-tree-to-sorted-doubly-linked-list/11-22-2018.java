/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class ResultType {
    Node small;
    Node big;
    ResultType(Node small, Node big) {
        this.small = small;
        this.big = big;
    }
}
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        ResultType result = helper(root);
        result.small.left = result.big;
        result.big.right = result.small;
        return result.small;
    }
    
    ResultType helper(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return new ResultType(root, root);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (left == null && right == null) {
            return new ResultType(root, root);
        }
        if (left == null) {
            root.right = right.small;
            right.small.left = root;
            return new ResultType(root, right.big);
        }
        if (right == null) {
            left.big.right = root;
            root.left = left.big;
            return new ResultType(left.small, root);
        }
        root.left = left.big;
        root.right = right.small;
        left.big.right = root;
        right.small.left = root;
        return new ResultType(left.small, right.big);
    }
}
