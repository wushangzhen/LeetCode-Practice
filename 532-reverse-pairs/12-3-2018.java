class Node {
    public int index;
    public int val;
    public Node(int index, int val) {
        this.index = index;
        this.val = val;
    }
}
public class Solution {
    /**
     * @param A: an array
     * @return: total of reverse pairs
     */

    public long reversePairs(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return (long) 0;
        }
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(new Node(i, A[i]));
        }
        Collections.sort(list, new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n1.val - n2.val;
            }
        });
        // 离散化
        A[list.get(0).index] = 0;
        for (int i = 1; i < A.length; i++) {
            if (list.get(i).val == list.get(i - 1).val) {
                A[list.get(i).index] = i - 1;
            } else {
                A[list.get(i).index] = i;
            }
        }
        long count = 0;
        int[] BIT = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            add(A[i], 1, BIT);
            count += getPrefixSum(A.length - 1, BIT) - getPrefixSum(A[i], BIT);
        }
        return count;
    }
    private int getPrefixSum(int index, int[] BIT) {
        int sum = 0;
        for (int i = index + 1; i > 0; i -= lowbit(i)) {
            sum += BIT[i];
        }
        return sum;
    }
    private void add(int index, int val, int[] BIT) {
        for (int i = index + 1; i <= BIT.length; i += lowbit(i)) {
            BIT[i] += val;
        }
    }
    private int lowbit(int x) {
        return x & -x;
    }
}
