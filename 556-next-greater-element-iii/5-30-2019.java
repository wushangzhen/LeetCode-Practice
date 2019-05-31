class Solution {
    public int nextGreaterElement(int n) {
        String value = String.valueOf(n);
        char[] sc = value.toCharArray();
        int m = sc.length;
        int i = m - 2;
        for (; i >= 0; i--) {
            if (sc[i] < sc[i + 1]) {
                break;
            }
        }
        if (i == -1) {
            return -1;
        }
        int j = m - 1;
        for (; j >= 0; j--) {
            if (sc[j] > sc[i]) {
                break;
            }
        }
        char temp = sc[i];
        sc[i] = sc[j];
        sc[j] = temp;
        int l = i + 1;
        int r = m - 1;
        while (l < r) {
            char tmp = sc[l];
            sc[l] = sc[r];
            sc[r] = tmp;
            l++;
            r--;
        }
        return Long.parseLong(String.valueOf(sc)) > Integer.MAX_VALUE ? -1 : (int)Long.parseLong(String.valueOf(sc));
    }
}
