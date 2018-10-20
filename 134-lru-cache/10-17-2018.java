class DNode {
    int val;
    int key;
    DNode prev;
    DNode next;
    
}

class LRUCache {
    private void addNode(DNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        
    }
    private void removeNode(DNode node) {
        DNode prev = node.prev;
        DNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    private void moveToHead(DNode node) {
        this.removeNode(node);
        this.addNode(node);
    }
    private DNode popTail() {
        DNode res = tail.prev;
        this.removeNode(res);
        return res;
    }
    private Map<Integer, DNode> cache = new HashMap<>();
    private int count;
    private int capacity;
    private DNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new DNode();
        head.prev = null;
        tail = new DNode();
        tail.next = null;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        this.moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        DNode node = cache.get(key);
        if (node == null) {
            DNode newNode = new DNode();
            newNode.key = key;
            newNode.val = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            count++;
            if (count > capacity) {
                DNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            node.val = value;
            this.moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
