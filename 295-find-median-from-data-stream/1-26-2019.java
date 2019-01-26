class MedianFinder {

    /** initialize your data structure here. */
    Queue<Integer> max;
    Queue<Integer> min;
    public MedianFinder() {
        max = new PriorityQueue<>();
        min = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());
        if (max.size() < min.size()) {
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if (max.size() == min.size()) {
            return (max.peek() + min.peek()) / 2.0;
        }
        return max.peek() / 1.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
