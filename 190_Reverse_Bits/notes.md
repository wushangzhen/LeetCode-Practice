从高位开始check每一位n是0还是1，然后在低位对应位置设置相应0或者1.

We can create a new uint32_t variable set it from the lowest position

use pos 1 << 31 & n determine whether the bit is 0, use | 1 to set the result corresponding bit as 1
