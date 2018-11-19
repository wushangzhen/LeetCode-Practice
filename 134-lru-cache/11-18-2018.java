class Dnode {
    Dnode prev;
    Dnode next;
    int key;
    int value;
}
public class LRUCache {
    /*
    * @param capacity: An integer
    */
    int capacity;
    Dnode dummy;
    Dnode tail;
    Map<Integer, Dnode> map;
    int k = 0;
    void addToHead(Dnode node) {
        node.next = dummy.next;
        dummy.next.prev = node;
        dummy.next = node;
        node.prev = dummy;
        k++;
    }
    Dnode deleteNode(Dnode node) {
        Dnode last = node.prev;
        last.next = node.next;
        node.next.prev = last;
        node.prev = null;
        node.next = null;
        k--;
        return node;
    }
    void update(Dnode node) {
        Dnode newNode = deleteNode(node);
        addToHead(newNode);
    }
    
    
    public LRUCache(int capacity) {
        // do intialization if necessary
        dummy = new Dnode();
        tail = new Dnode();
        dummy.next = tail;
        tail.prev = dummy;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Dnode node = map.get(key);
            update(node);
            return node.value;
        }
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            Dnode node = map.get(key);
            node.value = value;
            update(node);
            map.put(key, node);
            return;
        } else if (k >= capacity) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        Dnode node = new Dnode();
        node.key = key;
        node.value = value;
        addToHead(node);
        map.put(key, node);
    }
}
