class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> A = new ArrayList<>();
        for (int v : nums) {
            A.add((double) v);
        }
        return solve(A);
    }
    private boolean solve(List<Double> nums) {
        if (nums.size() == 0) {
            return false;
        }
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    List<Double> list = new ArrayList<>();
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) {
                            list.add(nums.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) {
                            continue;
                        }
                        if (k == 0) {
                            list.add(nums.get(i) + nums.get(j));
                        }
                        if (k == 1) {
                            list.add(nums.get(i) * nums.get(j));
                        }
                        if (k == 2) {
                            list.add(nums.get(i) - nums.get(j));
                        }
                        if (k == 3) {
                            if (nums.get(j) != 0) {
                                list.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                        }
                        if (solve(list)) {
                            return true;
                        }
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}
