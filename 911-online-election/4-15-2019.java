class TopVotedCandidate {
    int maxVote;
    int candidate;
    Map<Integer, Integer> res;
    Map<Integer, Integer> memo;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.maxVote = 0;
        this.candidate = -1;
        res = new HashMap<>();
        memo = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            memo.put(persons[i], memo.getOrDefault(persons[i], 0) + 1);
            if (memo.get(persons[i]) >= maxVote) {
                maxVote = memo.get(persons[i]);
                candidate = persons[i];
            }
            res.put(times[i], candidate);
        }
    }
    
    public int q(int t) {
        int start = 0;
        int end = times.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (times[mid] > t) {
                end = mid;
            } else if (times[mid] == t) {
                return res.get(times[mid]);     
            } else {
                start = mid;
            }
        }
        if (times[end] <= t) {
            return res.get(times[end]);
        }
        return res.get(times[start]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
