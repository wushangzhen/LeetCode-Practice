public class Solution { // LeetCode time limited exceed
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        if (numbers == null || numbers.length == 0) {
            return result;
        }
        int n = numbers.length;
        Arrays.sort(numbers);
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            if (visited.contains(numbers[i])) {
                continue;
            }
            visited.add(numbers[i]);
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && numbers[j - 1] == numbers[j]) {
                    continue;
                } 
                for (int k = j + 1; k < n; k++) {
                    if (k != j + 1 && numbers[k - 1] == numbers[k]) {
                        continue;
                    } 
                    if (numbers[j] + numbers[k] == -numbers[i]) {
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[k]);
                        result.add(new ArrayList<>(list));
                        list.clear();
                    }
                }
            }
        }
        return result;
    }
}
