public class Solution {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        int p1 = 0;
        int p2 = 0;
        int n = nums1.length;
        int m = nums2.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> resSet = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                resSet.add(nums2[i]);
            }
        }
        int[] res = new int[resSet.size()];
        Iterator<Integer> it = resSet.iterator();
        int k = 0;
        while (it.hasNext()) {
            res[k] = it.next();
            k++;
        }
        return res;
    }
}
