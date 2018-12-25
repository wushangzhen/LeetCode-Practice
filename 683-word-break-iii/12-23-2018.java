public class Solution {
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    int count = 0;
    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        if (s == null) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String str : dict) {
            max = Math.max(str.length(), max);
            set.add(str.toLowerCase());
        }
        s = s.toLowerCase();
        map.put("", 1);
        return dfs(s, set, max, map);
    }
    int dfs(String s, Set<String> set, int max, Map<String, Integer> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int count = 0;
        for (int i = 1; i <= s.length(); i++) {
            String str = s.substring(0, i);
            String str2 = s.substring(i);
            if (i > max) {
                break;
            }
            if (set.contains(str)) {
                count += dfs(str2, set, max, map);
            }
        }
        map.put(s, count);
        return count;
    }
}
