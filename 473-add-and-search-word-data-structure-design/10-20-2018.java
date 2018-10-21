class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean hasWord = false;
}

class WordDictionary {
    TrieNode dummy;

    /** Initialize your data structure here. */
    public WordDictionary() {
        dummy = new TrieNode();
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = dummy;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (cur.children[pos] == null) {
                cur.children[pos] = new TrieNode();
            }
            cur = cur.children[pos];
        }
        cur.hasWord = true;
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode cur = dummy;
        return match(0, word, cur);
    }
    boolean match(int start, String word, TrieNode cur) {
        if (cur == null) {
            return false;
        }
        if (start == word.length() && cur.hasWord) {
            return true;
        }
        if (start >= word.length()) {
            return false;
        }
        if (word.charAt(start) != '.') {
            int pos = word.charAt(start) - 'a';
            return match(start + 1, word, cur.children[pos]);
        } else {
            boolean flag = false;
            for (int i = 0; i < 26; i++) {
                flag = match(start + 1, word, cur.children[i]) || flag;
            }
            return flag;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
