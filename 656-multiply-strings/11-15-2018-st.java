class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "";
        }
        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n + m];
        int i, j;
        for (i = n - 1; i >= 0; i--) {
            int carry = 0;
            for (j = m - 1; j >= 0; j--) {
                int temp = result[i + j + 1] + carry + ((num1.charAt(i) - '0') * (num2.charAt(j) - '0'));
                carry = temp / 10;
                result[i + j + 1] = temp % 10;
            }
            result[i + j + 1] = carry;
        }
        i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n + m - 1 && result[i] == 0) {
            i++;
        }
        while (i < n + m) {
            sb.append(result[i]);
            i++;
        }
        return sb.toString();
    }
}
