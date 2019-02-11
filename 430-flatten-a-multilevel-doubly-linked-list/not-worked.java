/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    Node tail = null;
    public Node flatten(Node head) {
        Node dummy = new Node();
        Node cur = head;
        tail = dummy;
        helper(cur);
        Node temp = head;
        Node last = null;
        while (temp != null) {
            System.out.println(temp.val);
            last = temp;
            temp = temp.next;
        }
        System.out.println("---");
        while (last != dummy) {
            System.out.println(last.val);
            last = last.prev;
        }
        return dummy.next;
    }
    public void helper(Node cur) {
        while (cur != null) {
            tail.next = cur;
            cur.prev = tail;
            tail = tail.next;
            Node temp = cur.next;
            if (cur.child != null) {
                helper(cur.child);
                cur.child = null;
            }
            cur = temp;
        }
    }
}
