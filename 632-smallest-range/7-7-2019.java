class Element {
    int row;
    int idx;
    int val;
    public Element(int row, int idx, int val) {
        this.row = row;
        this.idx = idx;
        this.val = val;
    }
}

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new Element(i, 0, nums.get(i).get(0)));
            max = Math.max(max, nums.get(i).get(0));
        }
        int start = -1;
        int end = -1;
        int range = Integer.MAX_VALUE;
        while (pq.size() >= nums.size()) {
            Element e = pq.poll();
            if (max - e.val < range) {
                range = max - e.val;
                start = e.val;
                end = max;
            }
            if (e.idx + 1 < nums.get(e.row).size()) {
                int val = nums.get(e.row).get(e.idx + 1);
                max = Math.max(val, max);
                pq.add(new Element(e.row, e.idx + 1, val));
            }
        }
        return new int[]{start, end};
    }
}
