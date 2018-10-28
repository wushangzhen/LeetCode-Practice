public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || wordDict.size() == 0) {
            return res;
        }
        Map<String, List<String>> memo = new HashMap<>();
        memo.put("", new ArrayList<>());
        memo.get("").add("");
        return dfs(s, memo, wordDict);
    }
    List<String> dfs(String s, Map<String, List<String>> memo, 
        Set<String> wordDict) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }        
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            if (wordDict.contains(s1)) {
                List<String> res2 = dfs(s2, memo, wordDict);
                for (int j = 0; j < res2.size(); j++) {
                    if (res2.get(j).equals("")) {
                        list.add(s1);
                    } else {
                        list.add(s1 +  " " + res2.get(j));
                    }
                }
            }
        }
        memo.putIfAbsent(s, list);
        return list;
    }
}
