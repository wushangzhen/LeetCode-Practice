class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, res);
        return res;
    }
}
