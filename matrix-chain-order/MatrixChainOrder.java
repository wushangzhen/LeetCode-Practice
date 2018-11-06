public class MatrixChainOrder {
    private static int[][] m;
    private static int[][] s;
    public static void func(int[] p) {
        int n = p.length - 1;
        m = new int[n + 1][n + 1];
        s = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }
        for (int l = 2; l <= n; l++) { // list all the chain length
            for (int i = 1; i <= n - l + 1; i++) { // list all the position of chains start
                int j = i + l - 1; // i -> j is the length of chain 
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) { // list all the cut position
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] p = {5, 10, 3, 12, 5, 50, 6};
        MatrixChainOrder.func(p);
        for (int i = 0; i < p.length; i++) {
            for (int j = i; j < p.length; j++) {
                System.out.println("m[" + i + "][" + j + "] = " + m[i][j]);
            }
        }
        System.out.println("********");

        for (int i = 1; i < p.length; i++) {
            for (int j = i + 1; j < p.length; j++) {
                System.out.println("s[" + i + "][" + j + "] = " + s[i][j]);
            }
        }
    }

}
