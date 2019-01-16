class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (helper(i, gas, cost)) {
                return i;
            }
        }
        return -1;
    }
    
    boolean helper(int start, int[] gas, int[] cost) {
        int tank = 0;
        int n = gas.length;
        for (int i = start; i - start != n; i++) {
            if (tank < 0) {
                return false;
            }
            tank += gas[i % n] - cost[i % n];
        }
        if (tank < 0) {
            return false;
        }
        return true;
    }
}
