queue<T> que1;
queue<T> que2;

que1.push(start);
int currentLevel = 0;

while (!que1.empty()) {
    int size = que1.size();
    for (int i = 0; i < size; i++) {
        T head = que1.front();
        que1.pop();
        for (all neighbor of head) {
            que2.push(neighbor);
        }
    }
    queue<T> temp = que1;
    que1 = que2;
    que2 = temp;
    que2.clear();
    currentLevel++;
}
