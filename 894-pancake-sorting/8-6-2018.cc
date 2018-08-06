/**
 * class FlipTool {
 * public:
 *   static void flip(vector<int>& arr, int i);
 * };
 */
class Solution {
public:
    /**
     * @param array: an integer array
     * @return: nothing
     */
    void pancakeSort(vector<int> &array) {
        // Write your code here
        if (array.empty()) {
            return;
        }
        for (int i = array.size() - 1; i >= 0; i--) {
            int max = findMaxIndex(array, i);
            if (max != i) {
                FlipTool::flip(array, max);
                FlipTool::flip(array, i);
            }
        }
    }
private:
    int findMaxIndex(vector<int> &array. int index) {
        int max = INT_MIN;
        int ptr = 0;
        for (int i = 0; i <= index; i++) {
            if (array[i] >= max) {
                max = array[i];
                ptr = i;
            }
        }
        return ptr;
    }
};
