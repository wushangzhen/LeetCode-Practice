class Dnode {
    int val;
    int key;
    Dnode prev;
    Dnode next;
}
public class LRUCache {
    /*
    * @param capacity: An integer
    */
    private Map<Integer, Integer> keyToValue;
    private Map<Integer, Dnode> keyToDnode;
    private Dnode head, tail;
    private int cap;
    private int count = 0;
    private void addNode(Dnode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    private void removeNode(Dnode node) {
        Dnode pre = node.prev;
        pre.next = node.next;
        node.next.prev = pre;
    }
    private Dnode popTail() {
        Dnode lastNode = tail.prev;
        removeNode(lastNode);
        return lastNode;
    }
    private void addToHead(Dnode node) {
        removeNode(node);
        addNode(node);
    }
    
    
    
    public LRUCache(int capacity) {
        // do intialization if necessary
        this.cap = capacity;
        head = new Dnode();
        tail = new Dnode();
        head.next = tail;
        tail.prev = head;
        keyToValue = new HashMap<>();
        keyToDnode = new HashMap<>();
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!keyToValue.containsKey(key)) {
            return -1;
        }
        Dnode node = keyToDnode.get(key);
        addToHead(node);
        return node.val;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            keyToDnode.get(key).val = value;
            addToHead(keyToDnode.get(key));
            return;
        }
        Dnode newNode = new Dnode();
        newNode.key = key;
        newNode.val = value;
        if (count >= cap) {
            Dnode lastNode = popTail();
            keyToValue.remove(lastNode.key);
            addNode(newNode);
            keyToValue.put(key, value);
            keyToDnode.put(key, newNode);
            return;
        }
        addNode(newNode);
        keyToValue.put(key, value);
        keyToDnode.put(key, newNode);
        count++;
    }
}
