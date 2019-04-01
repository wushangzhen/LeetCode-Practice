class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            // (ab + c) % d = ((a % d)(b % d) + c % d) % d
            num = ((num % 5) * (2 % 5) + (A[i] % 5)) % 5;
            if (num == 0) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
