public class Solution {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numbers == null || numbers.length == 0) {
            return result;
        }
        int n = numbers.length;
        Arrays.sort(numbers);
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<Integer>();
            if (i != 0 && numbers[i - 1] == numbers[i]) {
                continue;
            }
            int m = target - numbers[i];
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int x = m - numbers[j];
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    if (numbers[left] + numbers[right] == x) {
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[left]);
                        list.add(numbers[right]);
                        result.add(new ArrayList<>(list));
                        list.clear();
                        left++;
                        right--;
                        while (left < right && numbers[left] == numbers[left - 1]) { 
                            left++;
                        }
                        while (left < right && numbers[right] == numbers[right + 1]) {
                            right--;
                        }
                        continue;
                    }
                    if (numbers[left] + numbers[right] < x) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
