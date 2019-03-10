/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
    public Node inorderSuccessor(Node x) {
        if (x.right == null) {
            Node p = x.parent;
            while (p != null && p.val < x.val) {
                p = p.parent;
            }
            return p;
        } else {
            Node r = x.right;
            while (r.left != null) {
                r = r.left;
            }
            return r;
        }
    }
}
