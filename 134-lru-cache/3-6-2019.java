class Dnode {
    public Dnode prev;
    public Dnode next;
    public int val;
    public int key;
}


class LRUCache {
    private int cap;
    private int size;
    private Map<Integer, Integer> key2Value;
    private Map<Integer, Dnode> key2Node;
    private Dnode dummy;
    private Dnode tail;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.key2Value = new HashMap<>();
        this.key2Node = new HashMap<>();
        this.dummy = new Dnode();
        this.tail = new Dnode();
        this.tail.prev = dummy;
        this.dummy.next = tail;
    }
    public Dnode remove(Dnode node) {
        Dnode pre = node.prev;
        pre.next = node.next;
        node.next.prev = pre;
        node.prev = null;
        node.next = null;
        return node;
    }
    public void addToHead(Dnode node) {
        Dnode temp = dummy.next;
        dummy.next = node;
        node.prev = dummy;
        temp.prev = node;
        node.next = temp;
    }
    public void update(Dnode node) {
        Dnode temp = remove(node);
        addToHead(temp);
    }
    
    public int get(int key) {
        if (!key2Value.containsKey(key)) {
            return -1;
        } else {
            Dnode node = key2Node.get(key);
            update(node);
        }
        return key2Value.get(key);
    }
    
    public void put(int key, int value) {
        if (key2Value.containsKey(key)) {
            key2Value.put(key, value);
            key2Node.get(key).val = value;
            update(key2Node.get(key));
            return;
        }
        if (size < cap) {
            key2Value.put(key, value);
            Dnode newNode = new Dnode();
            newNode.val = value;
            newNode.key = key;
            addToHead(newNode);
            key2Node.put(key, newNode);
            size++;
        } else {
            Dnode temp = tail.prev;
            remove(temp);
            key2Value.remove(temp.key);
            key2Node.remove(temp.key);
            key2Value.put(key, value);
            Dnode newNode = new Dnode();
            newNode.val = value;
            newNode.key = key;
            addToHead(newNode);
            key2Node.put(key, newNode);
        }  
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
