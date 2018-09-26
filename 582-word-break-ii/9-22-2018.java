public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        Map<String, List<String>> hash = new HashMap<>();
        hash.put("", new ArrayList<String>());
        hash.get("").add("");
        return dfs(s, wordDict, hash);
    }
    private List<String> dfs(String s, Set<String> wordDict,
        Map<String, List<String>> hash) {
        if (hash.containsKey(s)) {
            return hash.get(s);
        }
        List<String> ans = new ArrayList<>();
        for (int end = 1; end <= s.length(); end++) {
            String s1 = s.substring(0, end);
            String s2 = s.substring(end);
            if (wordDict.contains(s1)) {
                List<String> s2_res = dfs(s2, wordDict, hash);
                for (String item : s2_res) {
                    if (item == "") {
                        ans.add(s1);
                    } else {
                        ans.add(s1 + " " + item);
                    }
                }
            }
        }
        hash.put(s, ans);
        return ans;
    } 
}
