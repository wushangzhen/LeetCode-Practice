#include <iostream>

ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
  ListNode* p1 = l1;
  ListNode* p2 = l2;
  if (!l1 && l2) {
    return l2;
  }
  if (l1 && !l2) {
    return l1;
  }
  if (!l1 && !l2) {
    return NULL;
  }
  while (p1->next && p2->next) {
    p1->val += p2->val;
    p1 = p1->next;
    p2 = p2->next;
  }
  if (!p1) {
    p1->next = p2;
  }
  return p1;
}
