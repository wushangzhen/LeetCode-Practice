public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        Arrays.sort(numbers);
        int n = numbers.length;
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i != 0 && numbers[i - 1] == numbers[i]) {
                continue;
            }
            int m = target - numbers[i];
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (Math.abs(numbers[left] + numbers[right] + numbers[i] - target) < min) {
                    min = Math.abs(numbers[left] + numbers[right] + numbers[i] - target);
                    result = numbers[left] + numbers[right] + numbers[i];
                } 
                if (numbers[left] + numbers[right] == m) {
                    return target;
                }
                if (numbers[left] + numbers[right] < m) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
