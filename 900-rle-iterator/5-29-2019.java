class RLEIterator {
    int[] A;
    int p;
    int left;
    public RLEIterator(int[] A) {
        this.A = A;
        p = 0;
        left = A[p];
    }
    
    public int next(int n) {
        while (left < n && p + 2 < A.length) {
            p += 2;
            left += A[p];
        }
        if (left >= n) {
            left -= n;
            return A[p + 1];
        } else if (p + 2 == A.length) {
            left = 0; // exhaust all
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
