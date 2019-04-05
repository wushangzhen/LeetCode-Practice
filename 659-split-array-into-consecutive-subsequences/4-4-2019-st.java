class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();
        for (int i : nums) {
            freq.putIfAbsent(i, 0);
            need.putIfAbsent(i, 0);
            freq.put(i, freq.get(i) + 1);
        }
        for (int i : nums) {
            if (freq.get(i) == 0) {
                continue;
            } else if (need.get(i) > 0) {
                need.put(i, need.get(i) - 1);
                need.put(i + 1, need.getOrDefault(i + 1, 0) + 1);
            } else if (freq.containsKey(i + 1) && freq.containsKey(i + 2)
                      && freq.get(i + 1) > 0 && freq.get(i + 2) > 0) {
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                need.put(i + 3, need.getOrDefault(i + 3, 0) + 1);
            } else {
                return false;
            }
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }
}
