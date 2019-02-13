/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Map<Integer, ListNode> map = new HashMap<>();
        while (head != null) {
            map.put(head.val, head);
            head = head.next;
        }
        int size = G.length;
        Set<Integer> set = new HashSet<>();
        for (int item : G) {
            set.add(item);
        }
        for (int item : G) {
            if (map.get(item).next != null && set.contains(map.get(item).next.val)) {
                size--;
            }
        }
        return size;
    }
}
