public class MovingAverage {
    /*
    * @param size: An integer
    */
    int size;
    double sum;
    int currentSize;
    long[] arry;
    public MovingAverage(int size) {
        // do intialization if necessary
        this.size = size;
        sum = 0;
        currentSize = 0;
        arry = new long[size];
    }
    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        if (currentSize < size) {
            arry[currentSize] = val;
            sum += val;
            currentSize++;
            return sum / currentSize;
        } else {
            int index = currentSize % size;
            sum -= arry[index];
            arry[index] = val;
            sum += val;
            currentSize++;
            return sum / size;
        }
    }
}
