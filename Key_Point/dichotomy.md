The time complexity is LogN
查找数据长度为N，每次查找后减半，

第一次   N/2

...

第k次   N/2^k



最坏的情况下第k次才找到，此时只剩一个数据，长度为1。

即 N/2^k = 1

查找次数 k=log(N)。

