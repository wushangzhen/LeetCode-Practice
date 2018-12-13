class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0 ) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0) {
            return -1;
        }
        int p1 = 0;
        //int p2 = 0;
        char[] hc = haystack.toCharArray();
        char[] nc = needle.toCharArray();
        while (p1 < hc.length) {
            if (hc[p1] != nc[0]) {
                p1++;
                continue;
            } else {
                int k = 0;
                while (k < nc.length) {
                    if (p1 + k >= hc.length || hc[p1 + k] != nc[k]) { // 判断坐标合法
                        break;
                    }
                    k++;
                }
                if (k == nc.length) {
                    return p1;
                } else {
                    p1++;
                }
            }
        }
        return -1;
    }
}
