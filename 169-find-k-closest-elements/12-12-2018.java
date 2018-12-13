class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return res;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int n = arr.length;
        while (left >= 0 && right < n) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                res.add(arr[left]);
                left--;
            } else {
                res.add(arr[right]);
                right++;
            }
            if (res.size() == k) {
                Collections.sort(res);
                return res;
            }
            
        }
        while (left >= 0) {
            res.add(arr[left]);
            if (res.size() == k) {
                Collections.sort(res);
                return res;
            }
            left--;
        }
        while (right < n) {
            res.add(arr[right]);
            if (res.size() == k) {
                Collections.sort(res);
                return res;
            }
            right++;
        }
        return res;
    }
}
