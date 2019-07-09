class Solution {
    public int compress(char[] chars) {
        int l = 0;
        int r = 0;
        int n = chars.length;
        while (r < n) {
            char c = chars[r];
            int count = 0;
            while (r < n && chars[r] == c) {
                r++;
                count++;
            }
            if (count > 1) {
                chars[l++] = c;
                String str = String.valueOf(count);
                for (char cc : str.toCharArray()) {
                    chars[l++] = cc; 
                }
            } else {
                chars[l++] = c;
            }
        }
        return l;
    }
}
