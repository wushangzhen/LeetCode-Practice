class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            Set<Integer> set = map.get(stones[i]);
            for (int k : set) {
                for (int j = k - 1; j <= k + 1; j++) {
                    if (j > 0 && map.containsKey(stones[i] + j)) {
                        map.get(stones[i] + j).add(j);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}
