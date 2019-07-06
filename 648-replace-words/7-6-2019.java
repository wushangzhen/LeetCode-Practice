class TrieNode {
    boolean hasWord;
    TrieNode[] children;
    public TrieNode() {
        hasWord = false;
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void build(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.hasWord = true;
    }
    public int searchWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return -1;
            } else if (cur.children[c - 'a'].hasWord) {
                return i;
            }
            cur = cur.children[c - 'a'];
        }
        return -1;
    }
}

class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Trie root = new Trie();
        for (String d : dict) {
            root.build(d);
        }
        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split(" ")) {
            int index = root.searchWord(word);
            if (index == -1) {
                sb.append(word);
            } else {
                sb.append(word.substring(0, index + 1));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
