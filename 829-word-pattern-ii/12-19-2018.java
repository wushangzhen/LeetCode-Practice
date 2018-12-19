class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null) {
            return false;
        }
        char[] pc = pattern.toCharArray();
        return dfs(0, 0, pc, str, new HashMap<>(), new HashMap<>());
    }
    boolean dfs(int p, int s, char[] pc, String str, Map<Character, String> map1, Map<String, Character> map2) {
        if (s == str.length() && p == pc.length) {
            return true;
        }
        if (p >= pc.length || s >= str.length()) {
            return false;
        }
        boolean match = false;
        for (int i = s + 1; i <= str.length(); i++) {
            String temp = str.substring(s, i);
            if (map1.containsKey(pc[p])) {
                if (map1.get(pc[p]).equals(temp)) {
                    match = match || dfs(p + 1, i, pc, str, map1, map2);
                }
            } else {
                if (!map2.containsKey(temp)) {   
                    map1.put(pc[p], temp);
                    map2.put(temp, pc[p]);
                    match = match || dfs(p + 1, i, pc, str, map1, map2);
                    map1.remove(pc[p]);
                    map2.remove(temp);
                }
            }
        }
        return match;
    }
}
