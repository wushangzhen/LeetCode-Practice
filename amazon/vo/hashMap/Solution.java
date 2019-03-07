class ListNode {
    public ListNode next;
    public int val;
    public String key;
    public ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    ListNode[] array;
    final int MOD = 100;
    public Solution(int n) {
        array = new ListNode[n];
    }
    public void put(String key, int value) {
        int hashCode = hash(key);
        if (array[hashCode] == null) {
            ListNode newNode = new ListNode(value);
            newNode.key = key;
            array[hashCode] = newNode;
        } else {
            ListNode tail = array[hashCode];
            while (tail.next != null) {
                tail = tail.next;
            }
            ListNode newNode = new ListNode(value);
            newNode.key = key;
            tail.next = newNode;
        }
    }  
    public int hash(String key) {
        char[] sc = key.toCharArray();
        int sum = 0;
        for (int i = 0; i < sc.length; i++) {
            sum += sc[i] * 31;
            sum %= 100;
        }
        return sum;
    }
    public int get(String key) {
        int hashCode = hash(key);
        ListNode temp = array[hashCode];
        while (!temp.key.equals(key)) {
            temp = temp.next;
        }
        return temp.val;
    }
    public static void main(String[] args) {
        Solution solution = new Solution(100);
        solution.put("string", 2);
        System.out.println(solution.get("string"));
    }
}
