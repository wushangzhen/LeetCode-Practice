class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new LinkedList<>();
        int i = A.length - 1;
        int count = 0;
        for (; i >= 0; i--) {
            int tmp = K % 10;
            int d = A[i] + tmp + count;
            K /= 10;
            count = d / 10;
            res.add(0, d % 10);
        }
        while (K > 0) {
            int tmp = K % 10;
            int d = count + tmp;
            K /= 10;
            count = d / 10;
            res.add(0, d % 10);
        }
        if (count > 0) {
            res.add(0, count);
        }
        return res;
    }
}
