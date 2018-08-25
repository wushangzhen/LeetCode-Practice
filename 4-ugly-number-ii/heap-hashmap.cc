struct Cmp {
    bool operator()(long a, long b) {
        return a > b;
    }
};
class Solution {
public:
    /**
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    int nthUglyNumber(int n) {
        // write your code here
        priority_queue<long, vector<long>, Cmp> priQue;
        unordered_set<long> hashSet;
        long prime[3] = {2, 3, 5};
        for (int i = 0; i < 3; i++) {
            priQue.push(prime[i]);
            hashSet.insert(prime[i]);
        }
        long number = 1;
        for (int i = 1; i < n; i++) {
            number = priQue.top();
            priQue.pop();
            for (int j = 0; j < 3; j++) {
                long long result = prime[j] * number;
                if (hashSet.find(result) == hashSet.end()) {
                    priQue.push(result);
                    hashSet.insert(result);
                }
            }
        }
        
        return int (number);
    }
};
