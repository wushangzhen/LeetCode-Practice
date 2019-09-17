class Solution {
    public boolean canReorderDoubled(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (int k : map.keySet()) {
            if (map.get(k) == 0) {
                continue;
            }
            int want = k < 0 ? k / 2 : k * 2;
            if (k < 0 && k % 2 != 0 || map.get(k) > map.getOrDefault(want, 0)) {
                return false;
            }
            map.put(want, map.get(want) - map.get(k));
        }
        return true;
    }
}
