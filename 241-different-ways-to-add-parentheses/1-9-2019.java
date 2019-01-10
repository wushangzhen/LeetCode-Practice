class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (map.containsKey(input)) {
            return map.get(input);
        }
        if (input == null || input.length() == 0) {
            return new ArrayList<>();
        }
        int n = input.length();
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (input.charAt(i - 1) == '+' 
               || input.charAt(i - 1) == '-'
               || input.charAt(i - 1) == '*') {
                String part1 = input.substring(0, i - 1);
                String part2 = input.substring(i);
                List<Integer> list1 = diffWaysToCompute(part1);
                List<Integer> list2 = diffWaysToCompute(part2);
                for (int p1 : list1) {
                    for (int p2 : list2) {
                        int temp = 0;
                        switch(input.charAt(i - 1)) {
                            case '+':
                                temp = p1 + p2;
                                break;
                            case '-':
                                temp = p1 - p2;
                                break;
                            case '*':
                                temp = p1 * p2;
                                break;
                        }
                        res.add(temp);
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        map.put(input, res);
        return res;
    }
}
