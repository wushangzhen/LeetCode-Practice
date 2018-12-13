def Reverse(x):
    flag = 1
    if x < 0:
        flag = -1
    x = abs(x);
    while check(x) == False:
        temp = x
        temp2 = x
        while x != 0:
            print x
            temp = temp * 10 + x % 10
            x /= 10
        x = temp + temp2
    if flag == -1:
        return x * flag
    return x

def check(x):
    while (x != 0):
        if (x % 2 == 1):
            return False
        x /= 10
    return True
print Reverse(168)



