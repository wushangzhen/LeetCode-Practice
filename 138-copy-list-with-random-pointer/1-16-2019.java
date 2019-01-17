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
        Map<RandomListNode, RandomListNode> memo = new HashMap<>();
        RandomListNode dummy = new RandomListNode(-1);
        dummy.next = head;
        while (head != null) {
            memo.putIfAbsent(head, new RandomListNode(head.label));
            if (head.random != null) {
                memo.putIfAbsent(head.random, new RandomListNode(head.random.label));
                memo.get(head).random = memo.get(head.random);
            }
            if (head.next != null) {
                memo.putIfAbsent(head.next, new RandomListNode(head.next.label));
                memo.get(head).next = memo.get(head.next);
            }
            head = head.next;
        }
        return memo.get(dummy.next);
    }
}
