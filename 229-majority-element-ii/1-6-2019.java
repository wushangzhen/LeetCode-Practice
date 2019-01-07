class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // The list will only have at most 2 element
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int count1 = 0;
        int count2 = 0;
        int n1 = 0;
        int n2 = 0;
        for (int num : nums) {
            if (n1 == num) {
                count1++;
            } else if (n2 == num) {
                count2++;
            } else if (count1 == 0) {
                n1 = num;
                count1++;
            } else if (count2 == 0) {
                n2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == n1) {
                count1++;
            } else if (num == n2) {
                count2++;
            }
        }
        if (count1 > n / 3) {
            res.add(n1);
        } 
        if (count2 > n / 3) {
            res.add(n2);
        }
        return res;
    }
}
