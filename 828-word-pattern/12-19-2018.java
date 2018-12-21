class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null) {
            return false;
        }
        char[] pc = pattern.toCharArray();
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        String[] strs = str.split(" ");
        int i = 0;
        for (; i < pc.length; i++) {
            if (i >= strs.length) {
                return false;
            }
            if (map1.containsKey(pc[i])) {
                if (!map1.get(pc[i]).equals(strs[i])) {
                    return false;
                }
            } else if (map2.containsKey(strs[i])) {
                if (!map2.get(strs[i]).equals(pc[i])) {
                    return false;
                }
            } else {
                map1.put(pc[i], strs[i]);
                map2.put(strs[i], pc[i]);
            }
        }
        return i == strs.length;
    }
}
