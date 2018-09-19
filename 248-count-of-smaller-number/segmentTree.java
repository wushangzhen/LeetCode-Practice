class SegmentTree {
    int start, end, count;    
    SegmentTree left, right;
    SegmentTree(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
        left = null;
        right = null;
    }
}
public class Solution {
    /**
     * @param A: An integer array
     * @param queries: The query list
     * @return: The number of element in the array that are smaller that the given integer
     */
    public SegmentTree buildHelper(int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTree root = new SegmentTree(start, end, 0);
        if (start == end) {
            return root;
        }
        int mid = (start + end) / 2;
        root.left = buildHelper(start, mid);
        root.right = buildHelper(mid + 1, end);
        return root;
    } 
    public int query(SegmentTree root, int start, int end) {
        if (start > end || root == null) {
            return 0;
        }
        if (start <= root.start && root.end <= end) {
            return root.count;
        }
        int mid = (root.start + root.end) / 2;
        int leftcount = 0; 
        int rightcount = 0;
        if (start <= mid) {
            if (mid < end) {
                leftcount = query(root.left, start, mid);
            } else {
                leftcount = query(root.left, start, end);
            }
        }
        if (mid + 1 <= end) {
            if (mid + 1 > start) {
                rightcount = query(root.right, mid + 1, end);
            } else {
                rightcount = query(root.right, start, end);
            }
        }
        return leftcount + rightcount;
    }
    public void modifySegmentTree(SegmentTree root, int index, int value) {
        if (root == null) {
            return;
        }
        if (root.start == root.end && root.start == index) {
            root.count += value;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (index <= mid && index >= root.start) {
            modifySegmentTree(root.left, index, value);
        }
        if (mid + 1 <= index && index <= root.end) {
            modifySegmentTree(root.right, index, value);
        }
        root.count = root.left.count + root.right.count;
    }
    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        SegmentTree root = buildHelper(0, 10000);
        for (int i = 0; i < A.length; i++) {
            modifySegmentTree(root, A[i], 1);
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > 0) {
                result.add(query(root, 0, queries[i] - 1));
            }
        }
        return result;
    }
}
