class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if (n % W != 0) {
            return false;
        }
        Map<Integer, Integer> m = new TreeMap<>();
        for (int h : hand) {
            m.put(h, m.getOrDefault(h, 0) + 1);
        }
        for (int k : m.keySet()) {
            if (m.get(k) > 0) {
                for (int j = k + W - 1; j > k; j--) {
                    if (m.getOrDefault(j, 0) < m.get(k)) {
                        return false;
                    }
                    m.put(j, m.get(j) - m.get(k));
                }
            }
        }
        return true;
    }
}
