class Solution {
public:
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    int triangleCount(vector<int> &S) {
        // write your code here
        if (S.empty()) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        sort(S.begin(), S.end());
        for (int i = 0; i < S.size(); i++) {
            left = 0;
            right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
            
        }
        return count;
    }
};
