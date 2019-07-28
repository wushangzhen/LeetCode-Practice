/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Node lastLevel = root;
        if (root == null) {
            return root;
        }
        Node head = root.left == null ? root.right : root.left;
        while (head != null) {
            Node newHead = null;
            Node temp = head;
            while (lastLevel != null) {
                if (lastLevel.left != temp && lastLevel.left != null) {
                    temp.next = lastLevel.left;
                    temp = temp.next; 
                }
                if (temp.left != null && newHead == null) {
                    newHead = temp.left;
                }
                if (temp.right != null && newHead == null) {
                    newHead = temp.right;
                }
                if (lastLevel.right != temp && lastLevel.right != null) {
                    temp.next = lastLevel.right;
                    temp = temp.next;
                }
                if (temp.left != null && newHead == null) {
                    newHead = temp.left;
                }
                if (temp.right != null && newHead == null) {
                    newHead = temp.right;
                }
                lastLevel = lastLevel.next;
            }
            lastLevel = head;
            head = newHead;
        }
        return root;
    }
}
