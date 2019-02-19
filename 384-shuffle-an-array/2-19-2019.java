class Solution {
    int[] original;
    int[] array;
    Random rand;
    int max;
    public Solution(int[] nums) {
        array = nums;
        original = nums.clone();
        max = nums.length;
        rand = new Random();
    }
    
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone(); // this is important
        return array;
    }
    
    void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swap(i, rand.nextInt(max));
        }
        return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
