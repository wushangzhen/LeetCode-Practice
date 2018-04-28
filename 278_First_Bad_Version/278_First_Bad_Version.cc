#include <iostream>

bool isBadVersion(int version);

int firstBadVersion(int n) {
  long long front = 1;
  long long back = n;
  long long mid = 0;
  while (front <= back) {
    mid = (back + front) / 2;
    if (isBadVersion(mid)) {
      back = mid - 1;
    } else {
      front = mid + 1;
    }
  }
  return int(front);
}

int lo = 1, hi = n;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(isBadVersion(mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
