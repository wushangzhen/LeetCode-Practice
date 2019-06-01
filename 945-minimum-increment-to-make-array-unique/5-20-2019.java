class Solution {
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[100000];
        for (int a : A) {
            count[a]++;
        }
        int taken = 0;
        int res = 0;
        for (int i = 0; i < 100000; i++) {
            if (count[i] >= 2) {
                taken += count[i] - 1;
                res -= i * (count[i] - 1);
            } else if (taken > 0 && count[i] == 0) {
                res += i;
                taken--;
            }
        }
        return res;
    }
}
