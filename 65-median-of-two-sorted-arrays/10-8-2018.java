class Pair {
    int value;
    int array;
    int index;
    Pair(int value, int array, int index) {
        this.index = index;
        this.value = value;
        this.array = array;
    }
}
class PairComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.value - b.value;
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
        int n = A.length;
        int m = B.length;
        int sum = n + m;
        if (sum == 0) {
            return 0.0;
        }
        if (n == 0) {
            if (sum % 2 == 0) {
                return (B[sum / 2 - 1] + B[sum / 2]) / 2.0;
            } else {
                return (double) B[sum / 2];
            }
        }
        if (m == 0) {
            if (sum % 2 == 0) {
                return (A[sum / 2 - 1] + A[sum / 2]) / 2.0;
            } else {
                return (double) A[sum / 2];
            }
        }
        Queue<Pair> pq = new PriorityQueue<>(new PairComparator());
        pq.add(new Pair(A[0], 0, 0));
        pq.add(new Pair(B[0], 1, 0));
        Pair pair = new Pair(0, 0, 0);
        for (int i = 0; i < sum / 2; i++) {
            pair = pq.poll();
            int next = pair.index + 1;
            if (pair.array == 0) {
                if (next < A.length) {
                    pq.add(new Pair(A[next], pair.array, next));
                }
            }
            if (pair.array == 1) {
                if (next < B.length) {
                    pq.add(new Pair(B[next], pair.array, next));
                }
            }
        }
        if (sum % 2 == 0) {
            return (pair.value + pq.peek().value) / 2.0;
            
        } else {
            return pq.peek().value / 1.0;
        }
    }
}
