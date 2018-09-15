/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
class ListNodeComparator implements Comparator<ListNode> {
    public int compare(ListNode left, ListNode right) {
        return left.val - right.val;
    }
}
 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if (lists == null || lists.size() == 0) {
            return null;
        }
        Queue<ListNode> heap = new PriorityQueue<ListNode>(new ListNodeComparator());
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.offer(lists.get(i));
            }
        }
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            pre.next = node;
            if (node.next != null) {
                heap.offer(node.next);
            }
            pre = node;
        }
        return dummy.next;
    }
}

