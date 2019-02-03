class LinkedList {
    int value;
    LinkedList next;
    public LinkedList(int value) {
        this.value = value;
    }
}
public class ShuffleLinkedList {
    Random rand;
    public ShuffleLinkedList {
        rand = new Random();
    }
    public LinkedList Solution(LinkedList node) {

        if (node == null) {
            return node;
        }
        LinkedList slow = node;
        LinkedList fast = node.next;
        LinkedList last = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            last = slow;
            slow = slow.next;
        } 
        LinkedList dummy = new LinkedList(-1);
        LinkedList cur = dummy;
        last.next = null;
        LinkedList leftHalf = Solution(node);
        LinkedList rightHalf = Solution(slow);
        while (leftHalf != null && rightHalf != null) {
            if (rand.nextInt(2) == 0) {
                cur.next = leftHalf;
                leftHalf = leftHalf.next;
            } else {
                cur.next = rightHalf;
                rightHalf = rightHalf.next;
            }
            cur = cur.next;
            cur.next = null;
        }
        while (leftHalf != null) {
            cur.next = leftHalf;
        }
        while (rightHalf != null) {
            cur.next = rightHalf;
        }
        return dummy.next;
    }
}
