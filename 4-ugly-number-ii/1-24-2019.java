class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Queue<Long> pq = new PriorityQueue<>();
        Set<Long> hash = new HashSet<>();
        pq.add((long)1);
        int count = 0;
        while (count < n - 1) {
            long num = pq.poll();
            count++;
            for (int i = 0; i < primes.length; i++) {
                if (hash.contains(num * primes[i])) {
                    continue;
                }
                pq.add(num * primes[i]);
                hash.add(num * primes[i]);
            }
        }
        long res = pq.peek();
        return (int) res;
    }
}
