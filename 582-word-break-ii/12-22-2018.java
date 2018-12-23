class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        Set<String> wordSet = new HashSet<>();
        for (String str : wordDict) {
            wordSet.add(str);
        }
        Map<String, List<String>> memo = new HashMap<>();
        memo.put("", new ArrayList<>());
        return dfs(wordSet, s, memo);
    }
    List<String> dfs(Set<String> wordSet, String s, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        int n = s.length();
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String temp = s.substring(0, i);
            if (wordSet.contains(temp)) {
                String str = s.substring(i);
                List<String> list = dfs(wordSet, str, memo);
                if (str.length() == 0 && list.size() == 0) {
                    res.add(temp);
                    continue;
                } else {
                    for (String ss : list) {
                        String x = temp + " " + ss;
                        res.add(x);
                    }
                }
            }
        }
        memo.put(s, res);
        return res;
    }
}
