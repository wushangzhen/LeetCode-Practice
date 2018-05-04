#include <iostream>
using namespace std;
int main() {
  int a = 5;
  int b = 6;
  int* p = &a;
  //int* test = p;
  //cout << *test << endl;
  //cout << test << endl;
  //cout << p << endl;
  //p = &b;
  //cout << *test << endl; // test value is not changed by changing the addr of p 

  cout << *p << endl; 
  cout << p << endl; 

  int** pp = &p;
  cout << *pp << endl;
  *pp = &b;
  cout << *p << endl;
  
}
