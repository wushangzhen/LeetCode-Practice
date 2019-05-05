class Solution {
    private int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        int[] index = new int[n];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSort(nums, index, 0, n - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(count[i]);
        }
        return res;
    }
    public void mergeSort(int[] nums, int[] index, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, index, start, mid);
        mergeSort(nums, index, mid + 1, end);
        merge(nums, index, start, end);
    }
    public void merge(int[] nums, int[] index, int start, int end) {
        int mid = (start + end) / 2;
        int left_index = start;
        int right_index = mid + 1;
        int rightCount = 0;
        int[] new_indexes = new int[end - start + 1];
        int sort_index = 0;
        while (left_index <= mid && right_index <= end) {
            if (nums[index[left_index]] > nums[index[right_index]]) {
                new_indexes[sort_index++] = index[right_index++];
                rightCount++;
            } else {
                new_indexes[sort_index++] = index[left_index];
                count[index[left_index]] += rightCount;
                left_index++;
            }
        }
        while (left_index <= mid) {
            new_indexes[sort_index] = index[left_index];
            count[index[left_index]] += rightCount;
            left_index++;
            sort_index++;
        }
        while (right_index <= end) {
            new_indexes[sort_index++] = index[right_index++];
        }
        for (int i = start; i <= end; i++) {
            index[i] = new_indexes[i - start];
        }
    }
}
