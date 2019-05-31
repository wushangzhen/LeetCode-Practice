class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int r = sum / 3;
        int count = 0;
        int temp = 0;
        for (int a : A) {
            temp += a;
            if (temp == r) {
                count++;
                temp = 0;
            }
        }
        return count == 3;
    }
}
