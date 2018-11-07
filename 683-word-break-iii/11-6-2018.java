public class Solution {
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        Set<String> set = new HashSet<>();
        for (String str : dict) {
            set.add(str.toLowerCase());
        }
        s = s.toLowerCase();
        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 1);
        return dfs(s, memo, set);
    }
    int dfs(String s, Map<String, Integer> memo, Set<String> set) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        int count = 0;
        for (int i = 1; i <= s.length(); i++) {
            String str1 = s.substring(0, i);
            String str2 = s.substring(i);
            if (set.contains(str1)) {
                count += dfs(str2, memo, set);
            }
        }
        memo.put(s, count);
        return count;
    }
}
