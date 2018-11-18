class KthLargest {
    List<Integer> list;
    int k;
    public KthLargest(int k, int[] nums) {
        list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        this.k = k;
    }
    
    public int add(int val) {
        list.add(val);
        return findKth(0, list.size() - 1, list, k - 1);
    }
    int findKth(int left, int right, List<Integer> list, int kth) {
        if (left >= right) {
            return list.get(left);
        }
        int start = left;
        int end = right;
        int mid = (start + end) / 2;
        int pivot = list.get(mid);
        while (start <= end) {
            while (start <= end && list.get(start) > pivot) {
                start++;
            }
            while (start <= end && list.get(end) < pivot) {
                end--;
            }
            if (start <= end) {
                int temp = list.get(start);
                list.set(start, list.get(end));
                list.set(end, temp);
                start++;
                end--;
            }
        }
        if (start <= kth) {
            return findKth(start, right, list, kth);
        }
        if (kth <= end) {
            return findKth(left, end, list, kth);
        }
        return list.get(kth);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
