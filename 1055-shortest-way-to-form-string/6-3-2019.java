class Solution {
    // find a better method
    public int shortestWay(String source, String target) {
        int t = 0;
        int res = 0;
        while (t < target.length()) {
            int temp = t;
            for (int i = 0; i < source.length(); i++) {
                if (temp < target.length() && source.charAt(i) == target.charAt(temp)) {
                    temp++;
                }
            }
            if (temp == t) {
                return -1;
            }
            res++;
            t = temp;
        }
        return res;
        
    }
}
