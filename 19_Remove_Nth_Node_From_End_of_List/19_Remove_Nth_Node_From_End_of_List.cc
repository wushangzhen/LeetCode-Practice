#include <iostream>


//Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
  ListNode* removeNthFromEnd(ListNode* head, int n) {
    int length = 0;
    ListNode* node = head;
    if (n == 0) {
        return head;
    }
    while (node) {
      length++;
      node = node->next;
    }
    node = head;
    int count = 0;
    if (length - n == 0) {
        head = head->next;
        return head;
    }
    while (count != length - n - 1) {
      node = node->next;
      count++;
    }
    if (node->next && node->next->next) {
    node->next = node->next->next; 
    } else if (node->next && !node->next->next) {
        node->next = nullptr;
    }
    return head;
    }
ListNode* removeNthFromEnd(ListNode* head, int n)
    {
        ListNode** t1 = &head, *t2 = head;
        for(int i = 1; i < n; ++i)
        {
            t2 = t2->next;
        }
        while(t2->next != NULL)
        {
            t1 = &((*t1)->next); // 取地址返回的是上一个指针的地址
            t2 = t2->next;
        }
        *t1 = (*t1)->next;
        return head;
    }
};
