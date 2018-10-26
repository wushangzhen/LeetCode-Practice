public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        Map<String, List<String>> memo = new HashMap<>();
        memo.computeIfAbsent("", a -> new ArrayList<>()).add("");
        return dfs(s, wordDict, memo);
    }
    List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            if (wordDict.contains(s1)) {
                List<String> res2 = dfs(s2, wordDict, memo);
                for (String str : res2) {
                    if (str.equals("")) {
                        res.add(s1);
                    } else {
                        res.add(s1 + " " + str);
                    }
                }
            }
        }
        memo.put(s, res);
        return res;
    }
}
