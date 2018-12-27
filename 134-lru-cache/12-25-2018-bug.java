class Node {
    Node prev;
    Node next;
    int key;
    int val;
}
class LRUCache {
    private int cap;
    private Node dummy;
    private Node tail;
    private Map<Integer, Node> val2Node;
    private Map<Integer, Integer> keyToVal;
    private int size;
    private void addHead(Node node) {
        Node temp = dummy.next;
        dummy.next = node;
        node.prev = dummy;
        node.next = temp;
        temp.prev = node;
    }
    private Node remove(Node node) {
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
        return node;
    }
    private void removeToHead(Node node) {
        addHead(remove(node));
    }
    public LRUCache(int capacity) {
        this.cap = capacity;
        dummy = new Node();
        tail = new Node();
        dummy.next = tail;
        tail.prev = dummy;
        size = 0;
        val2Node = new HashMap<>();
        keyToVal = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
             return -1;
         }
         int val = keyToVal.get(key);
         addHead(remove(val2Node.get(val)));
         return val;
    }
    
    public void put(int key, int value) {
        if (keyToVal.containsKey(key)) {
            int temp = keyToVal.get(key);
            Node x = val2Node.get(temp);
            x.val = value;
            removeToHead(val2Node.get(temp));
            val2Node.remove(temp);
            val2Node.put(value, x);
            keyToVal.put(key, value);
        } else {
            Node node = new Node();
            node.val = value;
            node.key = key;
            if (size < cap) {
                keyToVal.put(key, value);
                val2Node.put(value, node);
                addHead(node);
                size++;
            } else {
                val2Node.remove(tail.prev.val);
                keyToVal.remove(tail.prev.key);
                remove(tail.prev);
                keyToVal.put(key, value);
                addHead(node);
                val2Node.put(value, node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
