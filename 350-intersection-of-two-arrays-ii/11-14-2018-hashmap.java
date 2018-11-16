class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        int n = nums1.length;
        int m = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums1[i], 0);
            map.put(nums1[i], map.get(nums1[i]) + 1);
        }
        for (int i = 0; i < m; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) != 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
