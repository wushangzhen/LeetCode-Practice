public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The median of the element inside the window at each moving
     */
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if (n == 0 || k == 0 || n < k) {
            return ans;
        }
        if (k == 1) {
            for (int num : nums) {
                ans.add(num);
            }
            return ans;
        }
        TreeSet<Node> maxHeap = new TreeSet<>();
        TreeSet<Node> minHeap = new TreeSet<>();
        initializeHeap(maxHeap, minHeap, nums, k);
        ans.add(maxHeap.last().val);
        for (int i = k; i < n; i++) {
            removeNode(maxHeap, minHeap, new Node(i - k, nums[i - k]));
            addNode(maxHeap, minHeap, new Node(i, nums[i]));
            ans.add(maxHeap.last().val);
        }
        return ans;
    }
    private void initializeHeap(TreeSet<Node> maxHeap, TreeSet<Node> minHeap, int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            maxHeap.add(new Node(i, nums[i]));
        }
        for (int i = k / 2; i > 0; --i) {
            minHeap.add(maxHeap.pollLast());
        }
    }
    
    private void removeNode(TreeSet<Node> maxHeap, TreeSet<Node> minHeap, Node node) {
        if (maxHeap.contains(node)) {
            maxHeap.remove(node);
            maxHeap.add(minHeap.pollFirst());
        } else {
            minHeap.remove(node);
        }
    }
    private void addNode(TreeSet<Node> maxHeap, TreeSet<Node> minHeap, Node node) {
        if (node.compareTo(maxHeap.last()) < 0) {
            maxHeap.add(node);
            minHeap.add(maxHeap.pollLast());
        } else {
            minHeap.add(node);
        }
    }
    class Node implements Comparable<Node> {
        public int idx;
        public int val;
        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
        public int compareTo(Node other) {
            if (this.val == other.val) {
                return this.idx - other.idx;
            }
            return this.val - other.val;
        }
    }
}
