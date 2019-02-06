class TrieNode {
    TrieNode[] children;
    boolean hasWord;
    public TrieNode() {
        this.children = new TrieNode[26];
        this.hasWord = false;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
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
    }
    public boolean search(String word) {
        char[] wc = word.toCharArray();
        TrieNode cur = root;
        return match(0, wc, cur);
    }
    public boolean match(int start, char[] wc,  TrieNode cur) {
        if (cur == null) {
            return false;
        }
        for (int i = start; i < wc.length; i++) {
            if (wc[i] == '.') {
                boolean flag = false;
                for (int j = 0; j < 26; j++) {
                    flag = flag || match(i + 1, wc, cur.children[j]);
                }
                return flag;
            } else if (cur.children[wc[i] - 'a'] == null) {
                return false;
            }
            cur = cur.children[wc[i] - 'a'];
        }
        return cur.hasWord;
    }
}


class WordDictionary {

    /** Initialize your data structure here. */
    Trie root;
    public WordDictionary() {
        this.root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        this.root.insert(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return root.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
