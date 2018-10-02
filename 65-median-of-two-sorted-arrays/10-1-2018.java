class Pair {
    int index;
    int array;
    int value;
    Pair(int index, int array, int value) {
        this.index = index;
        this.array = array;
        this.value = value;
    }
}
class PairComparator implements Comparator<Pair> {
    public int compare(Pair left, Pair right) {
        return left.value - right.value;
    }
}
public class Solution {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        if ((A == null || A.length == 0) && (B == null || B.length == 0)) {
            return 0.0;
        }
        if (A == null || A.length == 0) {
            int m = B.length;
            if (m % 2 == 0) {
                return (B[m / 2 - 1] + B[m / 2]) / 2.0;
            } 
            return B[m / 2] / 1.0;
        }
        if (B == null || B.length == 0) {
            int m = A.length;
            if (m % 2 == 0) {
                return (A[m / 2 - 1] + A[m / 2]) / 2.0;
            } 
            return A[m / 2] / 1.0;
        }
        Queue<Pair> queue = new PriorityQueue<>(new PairComparator());
        queue.add(new Pair(0, 0, A[0]));
        queue.add(new Pair(0, 1, B[0]));
        int n = A.length;
        int m = B.length;
        int sum = n + m;
        int median = (n + m) / 2;
        Pair prev = null;
        for (int i = 0; i < median; i++) {
            Pair pair = queue.poll();
            int nextIndex = pair.index + 1;
            prev = pair;
            if (pair.array == 0) {
                if (nextIndex < A.length) {
                    queue.add(new Pair(nextIndex, pair.array, A[nextIndex]));
                }
            } else {
                if (nextIndex < B.length) {
                    queue.add(new Pair(nextIndex, pair.array, B[nextIndex]));
                }
            }
        }
        if (sum % 2 == 1) {
            return (double)queue.peek().value;
        } else {
            return (queue.peek().value + prev.value) / 2.0;
        }
    }
}
