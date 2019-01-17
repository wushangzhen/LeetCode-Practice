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
            return null;
        }
        RandomListNode ptr = head;
        while (ptr != null) {
            RandomListNode newNode = new RandomListNode(ptr.label);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = ptr.next.next;
        }
        ptr = head;
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        RandomListNode oldHead = head;
        RandomListNode newHead = head.next;
        RandomListNode res = head.next;
        while (oldHead != null) {
            oldHead.next = oldHead.next != null ? oldHead.next.next : null;
            newHead.next = newHead.next != null ? newHead.next.next : null;
            oldHead = oldHead.next;
            newHead = newHead.next;
        }
        return res;
        
    }
}
