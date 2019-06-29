class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        int n = words.length;
        if (n == 0) {
            return list;
        }
        int m = words[0].length();
        for (int i = 0; i + m * n <= s.length(); i++) {
            String sub = s.substring(i, i + m * n);
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            for (int k = 0; k < m * n; k += m) {
                String ss = sub.substring(k, k + m);
                if (!count.containsKey(ss)) {
                    break;
                }
                seen.put(ss, seen.getOrDefault(ss, 0) + 1);
                if (seen.get(ss) > count.get(ss)) {
                    break;
                }
                j++;
            }
            if (j == n) {
                list.add(i);
            }
        }
        return list;
    }
}
