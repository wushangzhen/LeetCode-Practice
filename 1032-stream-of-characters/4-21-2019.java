class TrieNode {
    TrieNode[] children;
    boolean hasWord;
    public TrieNode() {
        children = new TrieNode[26];
        hasWord = false;
    }
}

class Trie {
    TrieNode root;
    public Trie(String[] words) {
        root = new TrieNode();
        for (String word : words) {
            build(word);
        }
    }
    void build(String word) {
        char[] wc = word.toCharArray();
        TrieNode cur = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.hasWord = true;
    }
}

class StreamChecker {
    Trie trie;
    TrieNode cur;
    StringBuilder sb;
    public StreamChecker(String[] words) {
        trie = new Trie(words);
        sb = new StringBuilder();
        cur = trie.root;
    }
    public boolean query(char letter) {
        sb.insert(0, letter);
        cur = trie.root;
        for (char c : sb.toString().toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return false;
            } else {
                cur = cur.children[c - 'a'];
                if (cur.hasWord) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
