public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s == null) {
            return false;
        }
        Map<String, Boolean> memo = new HashMap<>();
        memo.put("", true);
        for (String str : dict) {
            max = Math.max(str.length(), max);
            min = Math.min(str.length(), min);
        }
        return dfs(s, dict, memo);
    }
    boolean dfs(String s, Set<String> dict, Map<String, Boolean> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        boolean match = false;
        for (int i = 1; i <= max; i++) {
            if (i > s.length() && s.length() != 0) {
                break;
            }
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            if (min > s2.length() && s2.length() != 0) {
                continue;
            }
            if (dict.contains(s1)) {
                boolean res2 = dfs(s2, dict, memo);
                if (res2) {
                    match = true;
                    break;
                }
            }
        }
        memo.put(s, match);
        return match;
    }
}
