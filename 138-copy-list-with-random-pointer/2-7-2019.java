/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode p = head;
        while (p != null) {
            RandomListNode newNode = new RandomListNode(p.label);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        p = head;
        while (p != null) {
            p.next.random = (p.random == null) ? null : p.random.next;
            p = p.next.next;
        }
        p = head;
        RandomListNode newHead = p.next;
        RandomListNode p2 = newHead;
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
