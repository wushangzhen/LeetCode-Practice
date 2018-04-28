#include <iostream>

uint32_t reverseBits(uint32_t n) {
  unsigned pos1 = 1 << 31; // unsigned int = uint32
  unsigned pos2 = 1;
  uint32_t ret = 0;
  while (pos1) {
    if (pos1 & n) {
      ret |= pos2;
    }
    pos2 << 1;
    pos1 >> 1;
  }
  return ret;
}
