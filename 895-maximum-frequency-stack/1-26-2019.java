class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> memo;
    int max;
    public FreqStack() {
        freq = new HashMap<>();
        memo = new HashMap<>();
        max = 0;
    }
    
    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        if (f > max) {
            max = f;
        }
        freq.put(x, f);
        memo.computeIfAbsent(f, a -> new Stack<>()).push(x);
        
    }
    
    public int pop() {
        int x = memo.get(max).pop();
        freq.put(x, freq.get(x) - 1);
        if (memo.get(max).size() == 0) {
            max--;
        }
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
