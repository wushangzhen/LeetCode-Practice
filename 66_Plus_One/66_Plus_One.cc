class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int size = digits.size();
        int i = 1;
        if (digits[size-1] < 9) {
            digits[size-1]++; 
        } else {
            digits[size-1]++;
            while (digits[size-i] == 10 && i != size) {
                digits[size - i] = 0;
                digits[size - i - 1] += 1;
                i++;    
            }
        }
        if (digits[0] == 10) {
            digits[0] = 0;
            digits.insert(digits.begin(), 1);      
        }
        return digits;
    }
};
