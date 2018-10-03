class TrieNode {
    public TrieNode[] children;
    public boolean hasWord;
    public String str;
    public TrieNode() {
        children = new TrieNode[26];
        for (int i = 0; i < 26; ++i) {
            children[i] = null;
        }
        hasWord = false;
    }
    static public void addWord(TrieNode root, String word) {
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (now.children[c - 'a'] == null) {
                now.children[c - 'a'] = new TrieNode();
            }
            now = now.children[c - 'a'];
        }
        now.str = word;
        now.hasWord = true;
    }
}
public class Solution {
    /**
     * @param words: a set of stirngs
     * @param target: a target string
     * @param k: An integer
     * @return: output all the strings that meet the requirements
     */
    public List<String> kDistance(String[] words, String target, int k) {
        // write your code here
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            TrieNode.addWord(root, words[i]);
        }
        List<String> result = new ArrayList<>();
        int n = target.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            dp[i] = i; // current node to reform the target first i element minimum edit number
        }
        find(root, result, k, target, dp);
        return result;
    }
    public void find(TrieNode node, List<String> result, int k, String target, int[] dp) {
        int n = target.length();
        if (node.hasWord && dp[n] <= k) { // this node can become a word and can become target with minimum edit number which is smaller than k
            result.add(node.str);
        }
        int[] next = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            next[i] = 0; // new node's dp array;
        }
        for (int i = 0; i < 26; ++i) { // traverse the children;
            if (node.children[i] != null) {  // find the next char which is not null
                next[0] = dp[0] + 1;
                for (int j = 1; j <= n; j++) { // traverse target to find whether they are diffrent
                    if (target.charAt(j - 1) - 'a' == i) { // if they are same
                        next[j] = dp[j - 1];
                        //next[j] = Math.min(dp[j - 1], Math.min(next[j - 1] + 1, dp[j] + 1));
                    } else { // if they are diffrent
                        next[j] = Math.min(dp[j - 1] + 1, Math.min(next[j - 1] + 1, dp[j] + 1));
                    }
                }
                find(node.children[i], result, k, target, next); // dfs
            }
        }
    }
    
}
