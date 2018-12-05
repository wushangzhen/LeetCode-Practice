class SegmentTreeNode {
    int start, end;
    int sum;
    SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
        this.sum = sum;
    }
}
class SegmentTree {
    SegmentTreeNode root;
    public SegmentTree(int[] nums) {
        this.root = build(0, nums.length - 1, nums);
    }
    public SegmentTreeNode build(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        SegmentTreeNode node = new SegmentTreeNode(start, end, 0);
        if (start != end) {
            node.left = build(start, mid, nums);
            node.right = build(mid + 1, end, nums);
            node.sum = node.left.sum + node.right.sum;
        } else {
            node.sum = nums[start];
        }
        return node;
    }
    public int query(SegmentTreeNode root, int start, int end) {
        if (start == root.start && root.end == end) {
            return root.sum;
        }
        int mid = (root.start + root.end) / 2;
        int leftSum = 0;
        int rightSum = 0;
        if (start <= mid) {
            if (end <= mid) {
                leftSum = query(root.left, start, end);
            } else {
                leftSum = query(root.left, start, mid);
            }
        }
        if (mid < end) {
            if (mid < start) {
                rightSum = query(root.right, start, end);
            } else {
                rightSum = query(root.right, mid + 1, end);
            }
        }
        return leftSum + rightSum;
    }
    public void updateSegmentTree(SegmentTreeNode root, int index, int val) {
        if (root.start == index && root.end == index) {
            root.sum = val;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (root.start <= index && index <= mid) {
            updateSegmentTree(root.left, index, val);
        }
        if (mid < index && index <= root.end) {
            updateSegmentTree(root.right, index, val);
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
        st.updateSegmentTree(st.root, i, val);
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return st.query(st.root, i, j);
    }
}
