class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int left = 0;
        int right = 0;
        int max = 1;
        int n = tree.length;
        while (right < n) {
            if (!map.containsKey(tree[right])) {
                count++;
                map.put(tree[right], 0);
            }
            map.put(tree[right], map.get(tree[right]) + 1);
            right++;
            if (count <= 2) {
                max = Math.max(right - left, max);
            } 
            while (count > 2) {
                if (map.get(tree[left]) == 1) {
                    map.remove(tree[left]);
                    count--;
                } else {
                    map.put(tree[left], map.get(tree[left]) - 1);
                }
                left++;
            }
        }
        return max;
    }
}
