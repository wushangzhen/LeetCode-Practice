class MyLinkedList {

    /** Initialize your data structure here. */
    Dnode dummy;
    int size = 0;
    Dnode tail;
    public MyLinkedList() {
        dummy = new Dnode();
        tail = dummy;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Dnode cur = dummy.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Dnode newNode = new Dnode();
        newNode.val = val;
        if (dummy.next == null) {
            dummy.next = newNode;
            newNode.prev = dummy;
            tail = newNode;
        } else {
            newNode.next = dummy.next;
            dummy.next.prev = newNode;
            dummy.next = newNode;
            newNode.prev = dummy;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Dnode newNode = new Dnode();
        newNode.val = val;
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        Dnode cur = dummy.next;
        if (index > size) {
            return;
        } else if (index == size) {
            addAtTail(val);
            return;
        } else {
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            Dnode newNode = new Dnode();
            newNode.val = val;
            cur.prev.next = newNode;
            newNode.prev = cur.prev;
            cur.prev = newNode;
            newNode.next = cur;
        }
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Dnode cur = dummy.next;
        if (index >= size) {
            return;
        } else {
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            if (cur == tail) {
                tail = cur.prev;
                cur.prev.next = cur.next;
            } else {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
            }
        }
        size--;
    }
}

class Dnode {
    int val;
    Dnode prev;
    Dnode next;
    public Dnode() {};
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
