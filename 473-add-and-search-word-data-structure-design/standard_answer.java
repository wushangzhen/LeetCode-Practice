class TrieNode {
    
    TrieNode[] children = new TrieNode[26];
    boolean hasWord;
}
public class WordDictionary {
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    private TrieNode root = new TrieNode();
    public void addWord(String word) {
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
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here
        if (word == null) {
            return false;
        }
        return searchHelper(root, word, 0);
    }
    boolean searchHelper(TrieNode node, String word, int index) {
        if (node == null) {
            return false;
        }
        if (index >= word.length()) {
            return node.hasWord;
        }
        char pos = word.charAt(index);
        if (pos != '.') {
            int num = pos - 'a';
            return searchHelper(node.children[num], word, index + 1);
        } else {
            for (int i = 0; i < 26; i++) {
                if (searchHelper(node.children[i], word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
