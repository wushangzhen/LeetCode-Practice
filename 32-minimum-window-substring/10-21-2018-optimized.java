class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] map = new int[256];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        int left = 0;
        int n = s.length();
        int right = 0;
        int count = t.length();
        char[] sc = s.toCharArray();
        int head = -1;
        int len = Integer.MAX_VALUE;
        while (right < n) {
            if (map[sc[right]] > 0) {
                count--;
            }
            map[sc[right]]--;
            right++;
            while (count == 0) {
                if (right - left < len) {
                    len = right - left;
                    head = left;
                }
                if (map[sc[left]] == 0) {
                    count++;
                }
                map[sc[left]]++;
                left++;
            }
        }
        return head == -1 ? "" : s.substring(head, head + len);
    }
}
