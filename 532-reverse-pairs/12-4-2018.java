class Node {
    int index;
    int val;
    public Node(int index, int val) {
        this.index = index;
        this.val = val;
    }
}

class Solution {
    int[] C;
    int n;
    int[] A;
    public int lowbit(int x) {
        return x & -x;
    }
    public void add(int x, int val) {
        for (int i = x + 1; i <= n; i += lowbit(i)) {
            C[i] += val;
        }
    }
    public int sum(int x) {
        int res = 0;
        for (int i = x + 1; i > 0; i -= lowbit(i)) {
            res += C[i];
        }
        return res;
    }
    public void init(int[] A) {
        this.A = A;
        n = A.length;
        C = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(A[i], 1);
        }
    }
    public int reversePairs(int[] nums) {
        this.A = nums;
        n = A.length;
        C = new int[n + 1];
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new Node(i, nums[i]));
        }
        Collections.sort(list, new Comparator<Node>() {
            public int compare(Node node1, Node node2) {
                return node1.val - node2.val;
            } 
        });
        for (int i = 0; i < list.size(); i++) {
            if (i != 0 && list.get(i).val == list.get(i - 1).val) {
                nums[list.get(i).index] = i - 1;
            } else {
                nums[list.get(i).index] = i;
            }
        }
        //init(nums);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            add(nums[i], 1);
            sum += sum(A.length - 1) - sum(nums[i]);
        }
        return sum;
    }
}
