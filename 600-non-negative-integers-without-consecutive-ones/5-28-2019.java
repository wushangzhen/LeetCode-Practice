class Solution {
    public int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n = sb.length();
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = 1;
        b[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }
        int res = a[n - 1] + b[n - 1];
        String str = sb.toString();
        for (int i = n - 2; i >= 0; i--) {
            if (str.charAt(i) == '0' && str.charAt(i + 1) == '0') {
                res -= b[i];
            }
            if (str.charAt(i) == '1' && str.charAt(i + 1) == '1') { 
                break;
            }
        }
        return res;
    }
}
