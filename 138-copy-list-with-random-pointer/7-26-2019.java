/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p != null) {
            Node newNode = new Node();
            newNode.val = p.val;
            newNode.next = p.next;
            p.next = newNode;
            p = p.next.next;
        }
        p = head;
        while (p != null) {
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }
        p = head;
        Node newHead = head.next;
        Node p2 = newHead;
        while (p2.next != null) {
            p.next = p2.next;
            p = p.next;
            p2.next = p2.next.next;
            p2 = p2.next;
        }
        p.next = p2.next;
        return newHead;
    }
}
