class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(0, nums.length - 1, nums);
    }
    int mergeSort(int start, int end, int[] nums) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;
        System.out.println(mid);
        int res = 0;
        res += mergeSort(start, mid, nums);
        res += mergeSort(mid + 1, end, nums);
        res += merge(start, end, nums);
        return res;
    }
    int merge(int start, int end, int[] nums) {
        int left = start;
        int mid = (start + end) / 2;
        int right = mid + 1;
        int index = start;
        int[] temp = new int[nums.length];
        int res = 0;
        System.out.println();
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
        while (left <= mid && right <= end) {
            if (nums[left] > 2 * (long) nums[right]) {
                //System.out.println(start);
                res += mid - left + 1;
                //res += right - mid + 1;
            } 
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = nums[left++];
        }
        while (right <= end) {
            temp[index++] = nums[right++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
        return res;
    }
}
