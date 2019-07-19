class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int n = words.length;
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        int m = words[0].length();
        for (int i = 0; i + m * n <= s.length(); i++) {
            String sub = s.substring(i, i + m * n);
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            for (; j < sub.length(); j += m) {
                String w = sub.substring(j, j + m);
                if (!map.containsKey(w)) {
                    break;
                }
                seen.put(w, seen.getOrDefault(w, 0) + 1);
                if (seen.get(w) > map.get(w)) {
                    break;
                }
            }
            if (j == sub.length()) {
                res.add(i);
            }
        }
        return res;
    }
}
