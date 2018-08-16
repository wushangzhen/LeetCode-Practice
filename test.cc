#include "stdafx.h"; 
#include <iostream>  
#include <cmath> 
using namespace std; 

int main() { 
    double radius; 
    double area; 
    cin >> radius; 
    area = M_PI* radius * radius; 
    cout << "area is :" << area << endl; 
    return 0; 
} 
