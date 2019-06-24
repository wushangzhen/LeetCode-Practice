class TrieNode {
    int val = 0;
    int wordVal = 0;
    boolean hasWord = false;
    Map<Character, TrieNode> map;
    public TrieNode() {
        map = new HashMap<>();
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void build(String str, int x) {
        TrieNode cur = root;
        for (char c : str.toCharArray()) {
            if (!cur.map.containsKey(c)) {
                TrieNode temp = new TrieNode();
                cur.map.put(c, temp);
            }
            cur = cur.map.get(c);
            cur.val += x;
        }
        if (cur.hasWord) {
            int old = cur.wordVal;
            cur = root;
            for (char c : str.toCharArray()) {
                cur = cur.map.get(c);
                cur.val -= old; 
            }
        }
        cur.hasWord = true;
        cur.wordVal = x;
    }
    
    public int startsWith(String str) {
        TrieNode cur = root;
        for (char c : str.toCharArray()) {
            if (cur.map.containsKey(c)) {
                cur = cur.map.get(c);
            } else {
                return 0;
            }
        }
        return cur.val;
    }
}

class MapSum {

    /** Initialize your data structure here. */
    Trie trie;
    public MapSum() {
        trie = new Trie();
    }
    
    public void insert(String key, int val) {
        trie.build(key, val);
    }
    
    public int sum(String prefix) {
        return trie.startsWith(prefix);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
