public class LCS {
    public void compute(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        String[][] b = new String[len1 + 1][len2 + 1];
        int[][] c = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = "\\";
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = "up";
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = "left";
                }
            }
        }
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                System.out.print(String.format("%-7s", c[i][j] + "," + b[i][j]));
                System.out.print(" ");
                
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        new LCS().compute("10010101", "010110110");
    }
}
