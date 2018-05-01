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
  int count = 0;
  ListNode* pre;
  while (p1 && p2) {
    p1->val += p2->val;
    p1->val += count;
    if (p1->val > 9) {
      count = 1;
      p1->val %= 10;
    } else {
      count = 0;
    }
    pre = p1;
    p1 = p1->next;
    p2 = p2->next;
  }
  while (p1) {
    p1->val += count;
    if (p1->val > 9) {
      p1->val %= 10;
      count = 1;
    } else {
      count = 0;
    }
    pre = p1;
    p1 = p1->next;
  }
  while (p2) {
    pre->next = p2;
    p2->val += count;
    if (p2->val > 9) {
      p2->val %= 10;
      count = 1; 
    } else {
      count = 0;
    }
    pre = p2;
    p2 = p2->next;
  }
  if (count == 1) {
    ListNode* end = new ListNode(1);
    pre->next = end;
  }
  return l1;
    }
