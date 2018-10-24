class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        map.computeIfAbsent("", a -> new ArrayList<>()).add("");
        return dfs(s, map, wordDict);
    }
    List<String> dfs(String s, Map<String, List<String>> map, List<String> wordDict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String s1 = s.substring(0, i);
            String s2 = s.substring(i);
            if (wordDict.contains(s1)) {
                List<String> resS2 = dfs(s2, map, wordDict);
                for (String str : resS2) {
                    if (str == "") {
                        list.add(s1);
                    } else {
                        list.add(s1 + " " + str);
                    }
                }
            }
        }
        map.put(s, list);
        return list;
    }
}
