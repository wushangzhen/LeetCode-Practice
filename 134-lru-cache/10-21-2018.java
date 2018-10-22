class Dnode {
    int key;
    int value;
    Dnode prev;
    Dnode next;
}




class LRUCache {
    private Dnode dummy;
    private Dnode tail;
    int cap;
    Map<Integer, Dnode> map;
    public void addNode(Dnode node) {
        node.next = dummy.next;
        node.prev = dummy;
        dummy.next.prev = node;
        dummy.next = node;
    }
    public Dnode remove(Dnode node) {
        Dnode pre = node.prev;
        pre.next = node.next;
        node.next.prev = pre;
        return node;
    }
    public void moveToHead(Dnode node) {
        remove(node);
        addNode(node);
    }
    public Dnode removeTail() {
        return remove(tail.prev);
    }

    public LRUCache(int capacity) {
        cap = capacity;
        dummy = new Dnode();
        tail = new Dnode();
        dummy.next = tail;
        tail.prev = dummy;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key).value;
        Dnode node = map.get(key);
        moveToHead(node);
        return value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            moveToHead(map.get(key));
            return;
        }
        if (map.size() >= cap) {
            Dnode node = removeTail();
            map.remove(node.key);
        }
        Dnode node = new Dnode();
        node.key = key;
        node.value = value;
        map.put(key, node);
        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
