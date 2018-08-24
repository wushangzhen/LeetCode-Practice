class MovingAverage {
public:
    /*
    * @param size: An integer
    */
    int left = 0;
    int right = 0;
    int size;
    vector<int> vec;
    double sum = 0.0;
    MovingAverage(int size) {
        // do intialization if necessary
        this->size = size;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    double next(int val) {
        // write your code here
        vec.push_back(val);
        int currentSize = vec.size();
        if (vec.size() <= size) {
            sum += val;
            return sum / currentSize;
        }
        sum += val;
        sum -= vec[left];
        left++;
        return sum / size;
    }
};

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param = obj.next(val);
 */
