#include <iostream>

using namespace std;

//char* test(int *p){
//  cout << "p: " << p << endl;
//  cout << "*p: " << *p << endl;
//  cout << "&p: " << &p << endl;
//  char a[2] = {'a', 'b'};
//  char *p_test = a; 
//  return p_test;
//}
//
//int main(){
//  int t[2] = {2, 3};
//  int *ptr = t;
//  char *ptr1 = test(ptr);
//  cout << *(ptr1) << endl;
//}


int * test()
{
    int a[5] = {1, 2, 2, 2, 3};
    int * p = a;
    return p;
}

int main() {
     int* ptr = test();
     cout << *ptr << endl;
     return 0;
}
