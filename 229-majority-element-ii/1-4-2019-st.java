class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int m = 0;
        int n = 0;
        int cm = 0;
        int cn = 0;
        for (int num : nums) {
            if (num == m) {
                cm++;
            } else if (num == n) {
                cn++;
            } else if (cm == 0) {
                m = num;
                cm++;
            } else if (cn == 0) {
                n = num;
                cn++; 
            } else {
                cn--;
                cm--;
            }
        }
        cn = cm = 0;
        for (int num : nums) {
            if (num == n) {
                cn++;
            } else if (num == m) {
                cm++;
            }
        }
        int len = nums.length;
        if (cm > len / 3) {
            res.add(m);
        }
        if (cn > len / 3) {
            res.add(n);
        }
        return res;
    }
}
