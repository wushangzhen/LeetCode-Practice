class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public boolean hasWord = false;
}
public class Trie {
    private TrieNode root;
    public Trie() {
        // do intialization if necessary
        root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (cur.children[pos] == null) {
                cur.children[pos] = new TrieNode();
            }
            cur = cur.children[pos];
        }
        cur.hasWord = true;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (cur.children[pos] == null) {
                return false;
            }
            cur = cur.children[pos];
        }
        return cur.hasWord;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int pos = prefix.charAt(i) - 'a';
            if (cur.children[pos] == null) {
                return false;
            }
            cur = cur.children[pos];
        }
        return true;
    }
}
