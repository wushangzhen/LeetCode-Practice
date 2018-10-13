class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            char[] sc = str.toCharArray();
            for (char c : sc) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < count[i]; j++) {
                    sb.append((char)(i + 'a'));
                }
                sb.append("/");
            }
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(str);
        }
        return new ArrayList<>(map.values());
        
    }
}
