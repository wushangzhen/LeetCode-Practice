class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return helper(0, strs.length - 1, strs);
    }
    String helper(int start, int end, String[] strs) {
        if (start >= end) {
            return strs[start];
        }
        int mid = (start + end) / 2;
        String left = helper(start, mid, strs);
        String right = helper(mid + 1, end, strs);
        return commonPrefix(left, right);
    }
    String commonPrefix(String left, String right) {
        int length = Math.min(left.length(), right.length());
        int i = 0;
        for (; i < length; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                break;
            }
        }
        return left.substring(0, i);
    }
}
