class Solution {
    final int BASE = 1_000_000;
    public int strStr(String source, String target) {
        int n = target.length();
        if (n == 0) {
            return 0;
        }
        int m = source.length();
        if (m == 0) {
            return -1;
        }
        int power = 1;
        for (int i = 0; i < n; i++) {
            power = (power * 31) % BASE;
        }
        int targetCode = 0;
        for (int i = 0; i < target.length(); i++) {
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE; 
        }
        int hashCode = 0;
        for (int i = 0; i < source.length(); i++) {
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;
            if (i < n - 1) {
                continue;
            }
            if (i >= n) {
                hashCode = hashCode - (source.charAt(i - n) * power) % BASE;
                if (hashCode < 0) {
                    hashCode += BASE;
                }
            }
            if (hashCode == targetCode) {
                if (source.substring(i - n + 1, i + 1).equals(target)) {
                    return i - n + 1;
                }
            }
        }
        return -1;
    }
}
