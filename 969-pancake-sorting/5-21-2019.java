class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int x = A.length; x > 0; x--) {
            int i = 0;
            while (A[i] != x) {
                i++;
            }
            reverse(A, i);
            res.add(i + 1);
            reverse(A, x - 1);
            res.add(x);
        }
        return res;
    }
    void reverse(int[] A, int index) {
        int left = 0;
        int right = index;
        while (left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
    }
}
