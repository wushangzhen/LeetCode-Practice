public class MovingAverage {
    /*
    * @param size: An integer
    */
    int[] arry;
    double sum = 0;
    int index = 0;
    int size = 0;
    public MovingAverage(int size) {
        // do intialization if necessary
        arry = new int[size];
        this.size = size;
        
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        int temp = index % size;
        sum += val;
        index++;
        if (index <= size) {
            arry[index - 1] = val;
            return sum / index;
        } else {
            sum -= arry[temp];
            arry[temp] = val;
            return sum / size;
        }
    }
}
