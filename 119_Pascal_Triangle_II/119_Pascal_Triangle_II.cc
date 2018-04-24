class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> ints(rowIndex + 1, 1);
        for(int row = 0; row < rowIndex; row++) {
            for(int col = row; col > 0; col--) {
                ints[col] += ints[col - 1];
            }
        }
        return ints;
    }
};
