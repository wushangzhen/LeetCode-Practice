public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return result;
        }
        int n = numbers.length;
        Arrays.sort(numbers);
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            if (i != 0 && numbers[i - 1] == numbers[i]) {
                    continue;
            } 
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                if (numbers[left] + numbers[right] == -numbers[i]) {
                    list.add(numbers[i]);
                    list.add(numbers[left]);
                    list.add(numbers[right]);
                    result.add(new ArrayList<Integer>(list));
                    list.clear();
                    left++;
                    right--;
                    while (left < right && numbers[left] == numbers[left - 1]) {
                        left++;
                    }
                    while (left < right && numbers[right] == numbers[right + 1]) {
                        right--;
                    }
                } else if (numbers[left] + numbers[right] < -numbers[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
