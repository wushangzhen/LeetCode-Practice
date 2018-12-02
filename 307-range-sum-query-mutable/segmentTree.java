class SegmentTreeNode {
    SegmentTreeNode left, right;
    int sum, start, end;
    public SegmentTreeNode(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.left = null;
        this.right = null;
    }
}
class SegmentTree {
    SegmentTreeNode root;
    public SegmentTree(int[] nums) {
        root = build(0, nums.length - 1, nums);
    }
    public SegmentTreeNode build(int start, int end, int[] A) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        if (start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid, A);
            root.right = build(mid + 1, end, A);
            root.sum = root.left.sum + root.right.sum;
        } else {
            root.sum = A[start];
        }
        return root;
    }
    public int querySegmentTree(SegmentTreeNode root, int start, int end) {
        if (start == root.start && root.end == end) {
            return root.sum;
        }
        int mid = (root.start + root.end) / 2;
        int leftSum = 0;
        int rightSum = 0;
        if (start <= mid) {
            if (mid < end) {
                leftSum = querySegmentTree(root.left, start, mid);
            } else {
                leftSum = querySegmentTree(root.left, start, end);
            }
        }
        if (mid < end) {
            if (start <= mid) {
                rightSum = querySegmentTree(root.right, mid + 1, end);
            } else {
                rightSum = querySegmentTree(root.right, start, end);
            }
        }
        return leftSum + rightSum;
    }
    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
        if (root.start == index && root.end == index) {
            root.sum = value;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (root.start <= index && index <= mid) {
            modifySegmentTree(root.left, index, value);
        }
        if (mid < index && index <= root.end) {
            modifySegmentTree(root.right, index, value);
        }
        root.sum = root.left.sum + root.right.sum;
    }
}


class NumArray {
    SegmentTree st;
    int[] nums;

    public NumArray(int[] nums) {
        st = new SegmentTree(nums);
        this.nums = nums;
    }
    
    public void update(int i, int val) {
        st.modifySegmentTree(st.root, i, val);
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return st.querySegmentTree(st.root, i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
