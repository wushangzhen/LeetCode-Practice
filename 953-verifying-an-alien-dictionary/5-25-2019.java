class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] memo = new int[26];
        int i = 0;
        for (char c : order.toCharArray()) {
            memo[c - 'a'] = i++;
        }
        for (i = 0; i + 1 < words.length; i++) {
            if (compare(words[i], words[i + 1], memo) > 0) {
                return false;
            }
        }
        return true;
    }
    int compare(String word1, String word2, int[] memo) {
        int n = word1.length();
        int m = word2.length();
        int cmp = 0;
        for (int i = 0, j = 0; i < n && j < m && cmp == 0; i++, j++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                cmp = memo[word1.charAt(i) - 'a'] - memo[word2.charAt(i) - 'a'];
                break;
            }
        }
        return cmp == 0 ? n - m : cmp;
    } 
}
