# Love calculator

## Solution

```c++
#include <cstdio>
#include <cstring>
#include <iostream>
using namespace std;

int numToDigit(int n)
{
    int sum = 0;

    while(n >= 10) {
        while(n != 0) {
            sum = sum + (n % 10);
            n /= 10;
        }
        n = sum;
        sum = 0;
    }
    return n;
}

int main()
{
    char n1[30], n2[30];
    double s1, s2, temp;
    int l1, l2;

    while(gets(n1)) {
        gets(n2);
        s1 = 0;
        s2 = 0;
        l1 = strlen(n1);
        l2 = strlen(n2);
        for(int i = 0; i < l1; i++) {
            if(n1[i] >= 'a' && n1[i] <= 'z')
                s1 = s1 + (n1[i] - 96);
            else if(n1[i] >= 'A' && n1[i] <= 'Z')
                s1 = s1 + (n1[i] - 64);
        }

        for(int i = 0; i < l2; i++) {
            if(n2[i] >= 'a' && n2[i] <= 'z')
                s2 = s2 + (n2[i] - 96);
            else if(n2[i] >= 'A' && n2[i] <= 'Z')
                s2 = s2 + (n2[i] - 64);
        }

        s1 = numToDigit(s1);
        s2 = numToDigit(s2);

        if(s1 > s2) {
            temp = s1;
            s1 = s2;
            s2 = temp;
        }

        if(s2 != 0) {
            printf("%.2f %\n", s1/s2*100);
        } else {
            printf("\n");
        }
    }
    return 0;
}

```


**This is only for discussion and communication. Please don't use this for submission of assignments.**