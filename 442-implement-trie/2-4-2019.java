class TrieNode {
    TrieNode[] children;
    boolean hasWord;
    public TrieNode() {
        this.children = new TrieNode[26];
        this.hasWord = false;
    }
}

class Trie {

    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] wc = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < wc.length; i++) {
            if (cur.children[wc[i] - 'a'] == null) {
                cur.children[wc[i] - 'a'] = new TrieNode();
            }
            cur = cur.children[wc[i] - 'a'];
        }
        cur.hasWord = true;
        return;
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] wc = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < wc.length; i++) {
            if (cur.children[wc[i] - 'a'] == null) {
                return false;
            }
            cur = cur.children[wc[i] - 'a'];
        }
        return cur.hasWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] wc = prefix.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < wc.length; i++) {
            if (cur.children[wc[i] - 'a'] == null) {
                return false;
            }
            cur = cur.children[wc[i] - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
