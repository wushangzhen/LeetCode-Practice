class Solution {
public:
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    
    vector<vector<int>> permute(vector<int> &nums) {
        // write your code here
        vector<vector<int>> results;
        sort(nums.begin(), nums.end());
        vector<int> vec(nums.begin(), nums.end());
        bool end = false;
        while (!end) {
            vec = nextPermutation(vec, end);
            results.push_back(vec);
        }
        return results;
        
    }
private:
    vector<int> nextPermutation(vector<int> &vec, bool &end) {
        int i = vec.size() - 1;
        while (i > 0 && vec[i] < vec[i - 1]) {
            i--;
        }
        if (i <= 0) {
            end = true;
        } 
        if (i > 0) {
            int j = vec.size() - 1;
            while (j > 0 && vec[j] < vec[i - 1]) {
                j--;
            }
            swap(vec[i - 1], vec[j]);
        }
        swapSequenceToEnd(vec, i);
        return vec;
    }
    void swap(int &i, int &j) {
        int temp = i;
        i = j;
        j = temp;
    }
    void swapSequenceToEnd(vector<int> &vec, int i) {
        int j = vec.size() - 1;
        while (i >= 0 && j > i) {
            swap(vec[i], vec[j]);
            j--;
            i++;
        }
    }
};
