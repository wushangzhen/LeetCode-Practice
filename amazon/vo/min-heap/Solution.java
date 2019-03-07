public class Solution {
    private int size;
    private int maxSize;
    private int[] array;
    public Solution(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.array = new int[maxSize];
    }
    public int parent(int pos) {
        return (pos - 1) / 2;
    }
    public int leftChild(int pos) {
        return pos * 2 + 1;
    }
    public int rightChild(int pos) {
        return pos * 2 + 2;
    }
    public void heapify() {
        for (int i = size / 2; i >= 0; i--) {
            siftDown(i);
        }
    }
    public void siftDown(int pos) {
        while (leftChild(pos) < size) {
            int leftChild = leftChild(pos);
            int min = array[pos];
            int minIndex = pos;
            if (leftChild < size) {
                if (min > array[leftChild]) {
                    min = array[leftChild];
                    minIndex = leftChild;
                }
            }
            int rightChild = rightChild(pos);
            if (rightChild < size) {
                if (min > array[rightChild]) {
                    min = array[rightChild];
                    minIndex = rightChild;
                }
            }
            if (minIndex != pos) {
                int temp = array[pos];
                array[pos] = array[minIndex];
                array[minIndex] = temp;
                pos = minIndex;
            } else {
                break;
            }
        }
    }
    public int peek() {
        if (size == 0) {
            return -1;
        }
        return array[0];
    }
    public void insert(int value) {
        if (size == maxSize) {
            return;
        }
        array[size++] = value;
        heapify();
    }
    public int poll() {
        int temp = array[0];
        array[0] = array[--size];
        siftDown(0);
        return temp;
    }
    public void print() {
        for (int i = 0; 2 * i + 2 < size; i++) { 
            System.out.print(" PARENT : " + array[i] 
                     + " LEFT CHILD : " + array[2 * i + 1] 
                   + " RIGHT CHILD :" + array[2 * i + 2]); 
            System.out.println(); 
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution(9);
        s.insert(5);
        s.insert(2);
        s.insert(6);
        s.insert(7);
        s.insert(4);
        //s.print();
        while (s.size != 0) {
            System.out.println(s.poll());
        }
        //s.print();
    }
}
