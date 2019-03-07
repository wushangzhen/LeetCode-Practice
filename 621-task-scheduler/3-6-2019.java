class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] memo = new int[26];
        for (char c : tasks) {
            memo[c - 'A']++;
        }
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for (int i : memo) {
            if (i != 0) {
                pq.add(i);
            }
        }
        int time = 0;
        int i = 0;
        while (!pq.isEmpty()) {
            i = 0;
            List<Integer> list = new ArrayList<>();
            while (i <= n) {
                if (!pq.isEmpty()) {
                    if (pq.peek() > 1) { // 出现两次以上，如果只有一次的话直接用掉，不再加到pq里了
                        list.add(pq.poll() - 1);
                    } else {
                        pq.poll();
                    }
                }
                time++;
                if (pq.isEmpty() && list.size() == 0) { // terminate
                    break;
                }
                i++;
            }
            for (int item : list) {
                pq.add(item);
            }
        }
        return time;
    }
}
