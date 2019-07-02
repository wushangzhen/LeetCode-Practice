class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        int level = 0;
        while ((1 << level) - 1 < label) {
            level++;
        }
        for (; label >= 1; label /= 2, level--) {
            res.add(0, label);
            label = (1 << level) - 1 - label + (1 << (level - 1));
        }
        return res;
    }
}
