This is very classical problem. 

We can deal with it using two for loop. 

As the first problem in interview, very important we have to figure out special

circumstances. like input = "" do not use string = NULL or !string to judge, we 

can use the int m = input.length() and determine it by m == 0. 

do not use string1.length() - string2.length() to in for , it may overflow. we 

use int m n instead.
