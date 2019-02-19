class Solution {
    // 122
    //  19
    //  1098
    //  122
    //
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        if (n == 0 || m == 0) {
            return "";
        }
        int[] res = new int[n + m + 1];
        String rev1 = new StringBuilder(num1).reverse().toString();
        String rev2 = new StringBuilder(num2).reverse().toString();
        char[] sc1 = rev1.toCharArray();
        char[] sc2 = rev2.toCharArray();
        int i = 0;
        int j = 0;
        for (i = 0; i < n; i++) {
            int carry = 0;
            for (j = 0; j < m; j++) {
                int a = sc1[i] - '0';
                int b = sc2[j] - '0';
                int mul = a * b + carry + res[i + j];
                carry = mul / 10;
                res[i + j] = mul % 10;
            }
            res[i + j] += carry;
        }
        StringBuilder sb = new StringBuilder();
        int end = n + m - 1;
        while (end >= 0 && res[end] == 0) {
            end--;
        }
        if (end == -1) {
            return "0";
        }
        for (i = 0; i <= end; i++) {
            sb.append(res[i]);
        }
        return sb.reverse().toString();
    }
}
