class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (check(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }
    boolean check(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        Map<Character, Character> memo1 = new HashMap<>();
        Map<Character, Character> memo2 = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (memo1.containsKey(word.charAt(i)) && memo1.get(word.charAt(i)) != pattern.charAt(i)) {
                return false;
            }
            memo1.putIfAbsent(word.charAt(i), pattern.charAt(i));
        }
        boolean[] seen = new boolean[26];
        for (char p: memo1.values()) { // avoid one values to many keys  brilliant
            if (seen[p - 'a']) return false;
            seen[p - 'a'] = true;
        }
        return true;
    }
}
