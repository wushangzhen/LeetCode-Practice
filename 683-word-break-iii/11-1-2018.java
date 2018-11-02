public class Solution {
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        if (s == null || s.equals("")) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String str : dict) {
            set.add(str.toLowerCase());
        }
        s = s.toLowerCase();
        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 1);
        return dfs(0, s, memo, set);
    }
    int dfs(int start, String s, Map<String, Integer> memo, Set<String> set) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        int count = 0;
        for (int i = start; i < s.length(); i++) {
            String s1 = s.substring(0, i + 1);
            String s2 = s.substring(i + 1);
            if (set.contains(s1)) {
                count += dfs(0, s2, memo, set);
            }
        }
        memo.put(s, count);
        return count;
    }
}
