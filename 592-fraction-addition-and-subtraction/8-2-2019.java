class Solution {
    public String fractionAddition(String expression) {
        String[] es = expression.split("(?=[+-])");
        int n = es.length;
        int[] ds = new int[n];
        int[] ns = new int[n];
        for (int i = 0; i < n; i++) {
            String[] ee = es[i].split("/");
            ns[i] = Integer.parseInt(ee[0]);
            ds[i] = Integer.parseInt(ee[1]);
        }
        long dd = 1;
        long nn = 0;
        for (int i = 0; i < n; i++) {
            dd = ds[i] * dd; 
        }
        for (int i = 0; i < n; i++) {
            nn += dd / ds[i] * ns[i];
        }
        long A = Math.abs(gcd(nn, dd));
        String res = nn / A + "/" + dd / A;
        return res;
    }
    long gcd(long x, long y) {
        if (x == 0 || y == 0) {
            return x + y;
        }
        return gcd(y, x % y);
    }
}
