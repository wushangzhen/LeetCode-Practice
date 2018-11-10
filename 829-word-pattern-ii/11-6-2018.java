class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        char[] pc = pattern.toCharArray();
        Map<Character, String> hash1 = new HashMap<>();
        Map<String, Character> hash2 = new HashMap<>();
        int n = pattern.length();
        int m = str.length();
        return helper(0, pc, 0, str, hash1, hash2);
    }
    boolean helper(int pStart, char[] pc, int sStart, String str, 
                   Map<Character, String> hash1, Map<String, Character> hash2) {
        if (pStart == pc.length) {
            if (sStart == str.length()) {
                return true;
            } else {
                return false;
            }
        }
        if (sStart == str.length()) {
            return false;
        }
        boolean match = false;
        for (int i = sStart + 1; i <= str.length(); i++) {
            String s = str.substring(sStart, i);
            if (!hash1.containsKey(pc[pStart]) && !hash2.containsKey(s)) {
                hash1.put(pc[pStart], s);
                hash2.put(s, pc[pStart]);
                match = match || helper(pStart + 1, pc, i, str, hash1, hash2);
                hash1.remove(pc[pStart]);
                hash2.remove(s);
                if (match) {
                    break;
                }
            } else if (!hash1.containsKey(pc[pStart]) && hash2.containsKey(s)) {
                match = false;
            } else if (hash1.containsKey(pc[pStart]) && !hash2.containsKey(s)) {
                match = false;
            } else if (!hash1.get(pc[pStart]).equals(s)) {
                match = false;
            } else if (hash1.get(pc[pStart]).equals(s)) {
                match = match || helper(pStart + 1, pc, i, str, hash1, hash2);
                if (match) {
                    break;
                }
            }
        }
        return match;
    }
}
