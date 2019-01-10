class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            char[] sc = str.toCharArray();
            String t = "";
            if (str.length() != 0) {
                int distance = sc[0] - 'a';
                for (char c : sc) {
                    t += (char)('a' + (c - 'a' - distance + 26) % 26); // this is important
                }
            }
            map.putIfAbsent(t, new ArrayList<>());
            map.get(t).add(str);
        }
        for (String s : map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }
}
