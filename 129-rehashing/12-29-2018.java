/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null || hashTable.length == 0) {
            return new ListNode[0];
        }
        int n = hashTable.length;
        ListNode[] res = new ListNode[n * 2];
        int newCap = n * 2;
        for (ListNode node : hashTable) {
            while (node != null) {
                int index = (node.val % newCap + newCap) % newCap;
                if (res[index] != null) {
                    ListNode temp = res[index];
                    while (temp.next != null) {
                        temp = temp.next;
                    }
                    temp.next = node;
                    node = node.next;
                    temp.next.next = null;
                } else {
                    res[index] = node;
                    node = node.next;
                    res[index].next = null;
                }
            }
        }
        return res;
    }
};

