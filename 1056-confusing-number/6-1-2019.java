class Solution {
    public boolean confusingNumber(int N) {
        int temp = N;
        if (temp == 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        while (temp != 0) {
            int digit = temp % 10;
            if (digit == 1) {
                sb.append(1);
            } else if (digit == 6) {
                sb.append(9);
            } else if (digit == 9) {
                sb.append(6);
            } else if (digit == 0) {
                sb.append(0);
            } else if (digit == 8) {
                sb.append(8);
            } else {
                return false;
            }
            temp /= 10;
        }
        return Integer.parseInt(sb.toString()) != N;
        
    }
}
