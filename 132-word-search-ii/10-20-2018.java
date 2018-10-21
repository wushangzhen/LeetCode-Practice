class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean hasWord = false;
}
class Trie {
    TrieNode dummy;
    public Trie() {
        dummy = new TrieNode();
    }
    public void add(String word) {
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
    public boolean search(String word) {
        TrieNode cur = dummy;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (cur.children[pos] == null) {
                return false;
            }
            cur = cur.children[pos];
        }
        return cur.hasWord;  
    }
    public boolean startWith(String prefix) {
        TrieNode cur = dummy;
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


class Solution {
    Trie trie = new Trie();
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        if (board == null || board.length == 0) {
            return new ArrayList<>(result);
        }
        int n = board.length;
        int m = board[0].length;
        if (m == 0) {
            return new ArrayList<>(result);
        }
        for (String word : words) {
            trie.add(word);
        }
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs("", i, j, board, result, visited);
            }
        }
        return new ArrayList<>(result);
    }
    void dfs(String str, int i, int j, char[][] board, Set<String> result, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        char c = board[i][j];
        str += c;
        if (!trie.startWith(str)) {
            return;
        }
        if (trie.search(str)) {
            result.add(str);
        }
        visited[i][j] = true;
        dfs(str, i + 1, j, board, result, visited);
        dfs(str, i - 1, j, board, result, visited);
        dfs(str, i, j - 1, board, result, visited);
        dfs(str, i, j + 1, board, result, visited);
        visited[i][j] = false;
    }
}
