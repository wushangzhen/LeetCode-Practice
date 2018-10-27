class TrieNode {
    TrieNode[] children;
    boolean hasWord;
    public TrieNode() {
        children = new TrieNode[26];
        hasWord = false;
    }
}
class Trie {
    TrieNode dummy;
    public Trie() {
        dummy = new TrieNode();
    }
    void build(String str) {
        TrieNode cur = dummy;
        char[] sc = str.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            int pos = sc[i] - 'A';
            if (cur.children[pos] == null) {
                cur.children[pos] = new TrieNode();
            }
            cur = cur.children[pos];
        }
        cur.hasWord = true;
    }
    boolean search(String str) {
        TrieNode cur = dummy;
        char[] sc = str.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            int pos = sc[i] - 'A';
            if (cur.children[pos] == null) {
                return false;
            }
            cur = cur.children[pos];
        }
        return cur.hasWord;
    }
    boolean findPrefix(String str) {
        TrieNode cur = dummy;
        char[] sc = str.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            int pos = sc[i] - 'A';
            if (cur.children[pos] == null) {
                return false;
            }
            cur = cur.children[pos];
        }
        return true;
    }
}

class Solution {
    public boolean exist(char[][] board, String word) {
        Map<String, Boolean> map = new HashMap<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs("", i, j, board, word, visited)) {
                    return true;
                }
            }
        } 
        return false;
    }
    boolean dfs(String prefix, int i, int j, char[][] board, String word, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        prefix += board[i][j];
        visited[i][j] = true;
        if (!word.startsWith(prefix)) {
            visited[i][j] = false;
            return false;
        } 
        if (prefix.equals(word)) {
            return true;
        }
        boolean result = dfs(prefix, i + 1, j, board, word, visited) || dfs(prefix, i - 1, j, board, word, visited)
            || dfs(prefix, i, j + 1, board, word, visited) || dfs(prefix, i, j - 1, board, word, visited);
        visited[i][j] = false;
        return result;
    }
}
