class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int right = 0;
        int sum = 0;
        int count = 0;
        int n = A.length;
        map.put(0, 1);
        while (right < n) {
            sum += A[right];
            int target = sum - S;
            if (map.containsKey(target)) {
                count += map.get(target);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            right++;
        }
        return count;
    }
}
