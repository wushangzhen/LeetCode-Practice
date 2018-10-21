class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(strs[i].length(), min);
        }
        int start = 0;
        int end = min;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isCommon(mid, strs, min)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return strs[0].substring(0, (start + end) / 2);
    }
    boolean isCommon(int index, String[] strs, int min) {
        String str = strs[0].substring(0, index);
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(str)) {
                return false;
            }
        }
        return true;
    }
}
