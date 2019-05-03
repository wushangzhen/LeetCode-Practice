class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (letters[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        } 
        if (letters[end] <= target) {
            return letters[0];
        } else if (letters[start] > target){ 
            return letters[start];
        } else {
            return letters[end];
        }
    }
}
