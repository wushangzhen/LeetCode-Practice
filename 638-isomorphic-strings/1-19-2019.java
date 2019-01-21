class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < n; i++) {
            if (map1.containsKey(sc[i])) {
                if (tc[i] != map1.get(sc[i])) {
                    return false;
                }
            } else {
                map1.put(sc[i], tc[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (map2.containsKey(tc[i])) {
                if (sc[i] != map2.get(tc[i])) {
                    return false;
                }
            } else {
                map2.put(tc[i], sc[i]);
            }
        }
        return true;
    }
}
