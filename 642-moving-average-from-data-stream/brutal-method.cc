class MovingAverage {
public:
    /*
    * @param size: An integer
    */
    int left = 0;
    int size;
    vector<int> vec;
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
        double sum = 0.0;
        vec.push_back(val);
        if (vec.size() <= size) {
           for (int i = left; i < vec.size(); i++) {
              sum += vec[i]; 
           } 
           sum /= vec.size();
           return sum;
        }
        left++;
        for (int i = left; i < left + size; i++) {
            sum += vec[i];
        }
        sum /= size;
        return sum;
    }
};

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param = obj.next(val);
 */
