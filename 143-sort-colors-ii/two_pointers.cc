class Solution {
public:
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    void sortColors2(vector<int> &colors, int k) {
        // write your code here
        int count = 0;
        int left = 0;
        int right = colors.size() - 1;
        while (count < k) {
            int min = INT_MAX;
            int max = INT_MIN;
            for (int i = left; i <= right; i++) {
                min = std::min(colors[i], min);
                max = std::max(colors[i], max);
            }
            int cur = left;
            while (cur <= right) {
                if (colors[cur] == min) {
                    swap(colors, left, cur);
                    left++;
                    cur++;
                } else if (colors[cur] > min && colors[cur] < max) {
                    cur++;
                } else {
                    swap(colors, cur, right);
                    right--;
                }
            }
            count += 2;
        }
    }
    void swap(vector<int> &vec, int start, int end) {
        int temp = vec[start];
        vec[start] = vec[end];
        vec[end] = temp;
    }

};
